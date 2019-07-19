package com.tree.bootroad.x101Rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;

@Slf4j
public class CommonConsumer {

    public static String MQ_NAMESRV_ADDR = "localhost:9876";
    public static String SYNC_TOPIC = "sync";

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("syncProducer");
        consumer.setNamesrvAddr(MQ_NAMESRV_ADDR);
        consumer.subscribe(SYNC_TOPIC, "*");

        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            log.info("thread: {}, msgs: {}", Thread.currentThread().getName(), msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();
        log.info("consumer started !");
    }

}
