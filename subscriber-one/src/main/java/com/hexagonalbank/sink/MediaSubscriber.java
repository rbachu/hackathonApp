package com.hexagonalbank.sink;

import com.hexagonalbank.model.Announcement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import com.hexagonalbank.channel.InputChannel;

@Component
@EnableBinding({com.hexagonalbank.channel.InputChannel.class})
@Slf4j
public class MediaSubscriber {

    @StreamListener(target = InputChannel.MEDIA_INPUT)
    public void receive(Announcement message) {
        log.info("Media received this message- {} ", message);
    }

}
