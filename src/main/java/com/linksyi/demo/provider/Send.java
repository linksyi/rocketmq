package com.linksyi.demo.provider;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @description: 点对点模式
 * @author: Mr.LinksYi
 * @created: 2020/10/07 09:35
 */

public class Send {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("provider");
        //设置服务地址
        producer.setNamesrvAddr("192.168.111.128:9876");
        //开启
        producer.start();
        //创建消息
        Message msg = new Message("providerTopic","providerTag","hello rocketMq".getBytes());
        //发送消息
        SendResult sendResult = producer.send(msg);
        System.out.printf("%s%n", sendResult);
        producer.shutdown();
    }
}
