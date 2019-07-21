package com.tree.bootroad.x101Rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

@Slf4j
public class AsyncProducer {

    public static String MQ_NAMESRV_ADDR = "localhost:9876";
    public static String SYNC_TOPIC = "sync";
    public static String SYNC_TAG = "tagS";

    public static void main(String[] args) throws Exception {
        String content = "hello, rocketMQ ";
        DefaultMQProducer producer = new DefaultMQProducer("asyncProducer");
        producer.setNamesrvAddr(MQ_NAMESRV_ADDR);
        producer.start();

        for (int i = 0; i < 100; i++) {
            int index = i;
            String body = content + i;
            Message message = new Message(SYNC_TOPIC, SYNC_TAG, body.getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("index: {}, res: {}", index, sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    log.error("index: {}, e: {}", index, e);
                }
            });
        }
        producer.shutdown();
    }

}
