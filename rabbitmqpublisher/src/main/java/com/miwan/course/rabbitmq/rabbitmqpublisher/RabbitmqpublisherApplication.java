package com.miwan.course.rabbitmq.rabbitmqpublisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RabbitmqpublisherApplication implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqpublisherApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        SimpleMessage simpleMessage = SimpleMessage.builder()
                .name("Simple Message")
                .description("This is a simple message")
                .build();

        rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);
    }
}
