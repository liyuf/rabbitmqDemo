package com.example.rabbitmqdemo;

import com.example.rabbitmqdemo.pojo.User;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqdemoApplicationTests {
    public RabbitmqdemoApplicationTests() {
    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    //发送消息
    @Test
    public void contextLoads() {
        String msg = "hello,spring amqptemplate";
        User user = new User();
        user.setUsername("张胜男");
        user.setPassword("123456");
        amqpTemplate.convertAndSend("simple_queue",user);
        //等待2s再结束，避免虚拟机提前关闭
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
