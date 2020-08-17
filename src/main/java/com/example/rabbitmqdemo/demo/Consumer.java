package com.example.rabbitmqdemo.demo;

import com.example.rabbitmqdemo.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author :liyufei
 * @Decirption : todo
 * @date :2020/8/10 18:48
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare("simple_queue",false,false,false,null);
        //将队列绑定到交换机上
        channel.queueBind("simple_queue", "FANOUT", "");
        //定义消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //获取消息体body
                String message = new String(body);
                System.out.println(message);
                //模拟消费耗时2s
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //手动确认消息接收
//                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };

        //发送请求
        channel.basicConsume("simple_queue",true,defaultConsumer);
        //关闭通道
//        channel.close();
//        connection.close();

    }
}
