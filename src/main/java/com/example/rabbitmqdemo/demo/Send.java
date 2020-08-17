package com.example.rabbitmqdemo.demo;

import com.example.rabbitmqdemo.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author :liyufei
 * @Decirption : todo
 * @date :2020/8/10 18:30
 */
public class Send {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        //创建Channel通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare("simple_queue", false, false, false, null);
        //消息内容
        String message = "hello world";
        String messageNew;
        //循环发送消息
        for (int i = 0; i < 10; i++) {
            messageNew=message+i;
            //指定的队列发送消息
            channel.basicPublish("", "simple_queue", null, messageNew.getBytes());
        }

        //关闭通道
        channel.close();
        //关闭连接
        connection.close();

    }
}
