package com.hexagonalbank.sink;

import com.hexagonalbank.channel.InputChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({InputChannel.class})
@Slf4j
public class OrganizerSubscriber {

    @StreamListener(target = InputChannel.ORGANIZER_INPUT)
    public void receive(String message) {
        log.info("Organizer Received registration - {} ", message);
    }

}
