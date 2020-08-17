package com.example.rabbitmqdemo.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author :liyufei
 * @Decirption : todo
 * @date :2020/8/10 18:00
 */
public class ConnectionUtil {
    /**
     * 建立与RabbitMQ的连接
     */

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接地址
        connectionFactory.setHost("192.168.186.130");
        //设置连接端口
        connectionFactory.setPort(5672);
        //设置账号信息，用户名、密码、virtualhost
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("leyou");
        connectionFactory.setPassword("123321");
        //获取连接
        return connectionFactory.newConnection();
    }
}
