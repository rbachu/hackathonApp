package com.hexagonalbank.sink;

import com.hexagonalbank.channel.InputChannel;
import com.hexagonalbank.channel.OutputChannel;
import com.hexagonalbank.model.Idea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({InputChannel.class, OutputChannel.class})
@Slf4j
public class IdeaProcessor {


    @StreamListener(target = InputChannel.IDEA_INPUT)
    @SendTo(OutputChannel.IDEA_PROCESSED_OUTPUT)
    public Message<Idea> process(Message<Idea> message) {
        log.info(" Raw Idea received  is - {} - ", message);

        return processIdea(message.getPayload());
    }

    public Message<Idea> processIdea(Idea idea){

        String modifiedDescription = idea.getDescription().toUpperCase();
        log.info("Uppercase the description {} ",modifiedDescription);
       idea.setDescription(modifiedDescription);

        Message<Idea> message =  MessageBuilder.
                withPayload(idea)
                .setHeaderIfAbsent("location", idea.getLocation())
                .build();
        log.info("Publishing processed idea - {} ", message);

        return  message;
    }
}
