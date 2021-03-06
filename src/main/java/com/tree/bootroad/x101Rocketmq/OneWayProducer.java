package com.tree.bootroad.x101Rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

@Slf4j
public class OneWayProducer {

    public static String MQ_NAMESRV_ADDR = "localhost:9876";
    public static String SYNC_TOPIC = "sync";
    public static String SYNC_TAG = "tagOneWay";

    public static void main(String[] args) throws Exception {
        String content = "hello, rocketMQ ";
        DefaultMQProducer producer = new DefaultMQProducer("oneWayProducer");
        producer.setNamesrvAddr(MQ_NAMESRV_ADDR);
        producer.start();

        for (int i = 0; i < 100; i++) {
            String body = content + i;
            Message message = new Message(SYNC_TOPIC, SYNC_TAG, body.getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(message);
        }
        producer.shutdown();
    }

}
