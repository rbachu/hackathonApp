package com.hexagonalbank.sink;


import com.hexagonalbank.channel.InputChannel;
import com.hexagonalbank.model.Idea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;


@EnableBinding(InputChannel.class)
@Slf4j
public class PartitionSubscriber {

/*
    @StreamListener(InputChannel.PARTITION_INPUT)
    public void listen(@Payload String in, @Header(AmqpHeaders.CONSUMER_QUEUE) String partition) {
        log.info(" {} received from partition {} ",in, partition);
    }*/

    @StreamListener(target = InputChannel.PARTITION_INPUT)
    public void receive(String message) {
        log.info(" Message received by third partition subscriber is - {} - ", message);

    }
}
