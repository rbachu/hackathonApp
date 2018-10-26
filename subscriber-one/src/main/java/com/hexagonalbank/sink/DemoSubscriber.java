package com.hexagonalbank.sink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Sink.class})
@Slf4j
public class DemoSubscriber {

    @StreamListener(target = Sink.INPUT)
    public void receive(String message) {
        log.info("Message received is - {} ", message);
    }

}