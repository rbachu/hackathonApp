package com.hexagonalbank.source;

import com.hexagonalbank.model.Announcement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static com.hexagonalbank.channel.OutputChannel.ANNOUNCEMENT_OUTPUT;

@Component
@EnableBinding({com.hexagonalbank.channel.OutputChannel.class})
@Slf4j
public class AnnouncementPublisher {


  @InboundChannelAdapter(channel = ANNOUNCEMENT_OUTPUT, poller=@Poller(fixedDelay="2000"))
    public Message<Announcement> announceHackathonMessage(){

        Announcement announcement = new Announcement();
        announcement.setTitle("Hackathon Contest");
        announcement.setDescription("All Hexagonal bank employees ..participate and win amazing prizes");


        Message<Announcement> message =  MessageBuilder.
                withPayload(announcement).
                setHeader("organizedBy","Hexa-Team")
                .build();
        log.info("Publishing announcement - {}", message);
        return  message;
    }

}
