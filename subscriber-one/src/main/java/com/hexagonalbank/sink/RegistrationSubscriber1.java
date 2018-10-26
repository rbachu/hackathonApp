package com.hexagonalbank.sink;

import com.hexagonalbank.channel.InputChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({com.hexagonalbank.channel.InputChannel.class})
@Slf4j
public class RegistrationSubscriber1 {

    @StreamListener(target = InputChannel.REGISTRATION_INPUT)
    public void receive(String message) {
        log.info("Received registration - {} ", message);
    }

}
