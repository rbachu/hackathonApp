package com.hexagonalbank.sink;

import com.hexagonalbank.channel.InputChannel;
import com.hexagonalbank.model.Announcement;
import com.hexagonalbank.model.Idea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@EnableBinding({com.hexagonalbank.channel.InputChannel.class})
@Component
public class IdeaSubscriber {


    @StreamListener(target = InputChannel.IDEA_PROCESSED_INPUT, condition = "headers['location']=='Chennai'")
    public void receive(Message<Idea> message) {
        log.info(" Idea received at Chennai Office is - {} - ", message);

    }
}
