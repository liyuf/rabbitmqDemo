package com.example.rabbitmqdemo.springamqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author :liyufei
 * @Decirption : todo
 * @date :2020/8/10 21:17
 */
@Component
public class Listener {
    /**
     * 这是一个消费者的处理函数，通过@RabbitListener申明要监听的队列
     * @param msg 接收到的消息，spring 会把接收到的字节消息发序列化成任意对象
     */
//    @RabbitListener(queues = "simple_queue")
    public void listenMsg(String msg) {
        System.out.println(msg);
    }
}
