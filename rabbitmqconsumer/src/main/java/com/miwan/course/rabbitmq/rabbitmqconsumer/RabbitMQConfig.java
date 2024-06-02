package com.miwan.course.rabbitmq.rabbitmqconsumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue testQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    ConnectionFactory connectionFactory() {
        // todo move host to properties
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest"); // todo add username to properties
        cachingConnectionFactory.setPassword("guest"); // todo add password to properties
        return cachingConnectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory());
        messageListenerContainer.setQueues(testQueue());
        messageListenerContainer.setMessageListener(new RabbitMqMessageListener());
        return messageListenerContainer;
    }

    private static final String QUEUE_NAME = "TestQueue";

}
