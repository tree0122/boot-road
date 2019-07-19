package com.tree.bootroad.x101Rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

@Slf4j
public class OrderedProducer {

    public static String MQ_NAMESRV_ADDR = "localhost:9876";
    public static String ORDERED_TOPIC = "ordered";
    public static String[] TAGS = {"tagA", "tagB", "tagC", "tagD", "tagE"};

    public static void main(String[] args) throws Exception {
        String content = "hello, rocketMQ ";
        DefaultMQProducer producer = new DefaultMQProducer("orderedProducer");
        producer.setNamesrvAddr(MQ_NAMESRV_ADDR);
        producer.start();

        for (int i = 0; i < 100; i++) {
            int orderId = i % 100;
            String tag = TAGS[i % TAGS.length];
            String body = content + i;
            Message message = new Message(ORDERED_TOPIC, tag, "KEY" + i, body.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message, (mqs, msg, arg) -> {
                Integer id = (Integer) arg;
                return mqs.get(id % mqs.size());
            }, orderId);
            log.info("result: {}", result);
        }
        producer.shutdown();
    }

}
