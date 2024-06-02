package com.miwan.course.rabbitmq.rabbitmqconsumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMqMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("RabbitMqMessageListener is consuming Message - " + new String(message.getBody()));
    }
}
