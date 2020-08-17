package com.example.rabbitmqdemo.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :liyufei
 * @Decirption : todo
 * @date :2020/8/10 21:58
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public MessageConverter messageConverter(){
       return new Jackson2JsonMessageConverter();
    }
}
