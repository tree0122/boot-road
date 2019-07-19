package com.tree.bootroad.x101Rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

@Slf4j
public class OrderedConsumer {

    public static String MQ_NAMESRV_ADDR = "localhost:9876";
    public static String ORDERED_TOPIC = "ordered";

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("orderedProducer");
        consumer.setNamesrvAddr(MQ_NAMESRV_ADDR);
        consumer.subscribe(ORDERED_TOPIC, "*");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            log.info("thread: {}, context: {}, msgs: {}", Thread.currentThread().getName(), context, msgs);
            context.setAutoCommit(false);
            return ConsumeOrderlyStatus.SUCCESS;
        });

        consumer.start();
        log.info("consumer started !");
    }

}
