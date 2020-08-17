package com.example.rabbitmqdemo.demo;

import com.example.rabbitmqdemo.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author :liyufei
 * @Decirption : todo
 * @date :2020/8/10 20:57
 */
public class Send2Exchange {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare("FANOUT", "fanout");
        //法发送消息
        String message = "hello everyone";
        channel.basicPublish("FANOUT", "", null, message.getBytes());
        //关闭连接
        channel.close();
        connection.close();
    }
}
