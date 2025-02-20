package com.miwan.course.rabbitmq.rabbitmqpublisher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleMessage implements Serializable {
    private String name;

    private String description;
}
