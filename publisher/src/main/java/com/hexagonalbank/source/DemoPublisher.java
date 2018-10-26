package com.hexagonalbank.source;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Source.class})
@Slf4j
public class DemoPublisher {


  @InboundChannelAdapter(channel = Source.OUTPUT, poller=@Poller(fixedDelay="6000"))
    public Message<String> announceHackathon(){
        Message<String> message =  MessageBuilder.
                withPayload("Hi Earthians , This is a hello world message and would remain so..")
                .build();

        log.info("Publishing demo message -  {}",message);
        return message;
    }
}
