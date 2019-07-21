package com.tree.bootroad.x101Rocketmq;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TransactionProducer {

    public static String MQ_NAMESRV_ADDR = "localhost:9876";
    public static String SYNC_TOPIC = "transaction";
    public static String SYNC_TAG = "tagS";

    public static void main(String[] args) throws Exception {
        String content = "hello, rocketMQ ";

        HashSet<Integer> set = Sets.newHashSet();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1000)
        );
        TransactionMQProducer producer = new TransactionMQProducer("transactionProducer");
        producer.setExecutorService(executor);
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                log.info("msg: {}, arg: {}", msg, arg);
                return LocalTransactionState.COMMIT_MESSAGE;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                log.info("msg: {}", msg);
                String body = new String(msg.getBody());
                if (set.contains(body)){
                    return LocalTransactionState.COMMIT_MESSAGE;
                }
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        });
        producer.setNamesrvAddr(MQ_NAMESRV_ADDR);
        producer.start();

        for (int i = 0; i < 100; i++) {
            set.add(i);
            String body = content + i;
            Message message = new Message(SYNC_TOPIC, SYNC_TAG, body.getBytes(RemotingHelper.DEFAULT_CHARSET));
            TransactionSendResult sendResult = producer.sendMessageInTransaction(message, i);
            log.info("res: {}", sendResult);
        }
        producer.shutdown();
    }

}
