package com.hexagonalbank.sink;

import com.hexagonalbank.channel.InputChannel;
import com.hexagonalbank.model.Announcement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({com.hexagonalbank.channel.InputChannel.class})
@Slf4j
public class AnnouncementSubscriber {

    @StreamListener(target = InputChannel.ANNOUNCEMENT_INPUT)
    public void receive(Message<Announcement> message) {
        log.info(" Announcement Message received is - {} - organized by {}",
                message.getPayload(), message.getHeaders().get("organizedBy"));

    }

}