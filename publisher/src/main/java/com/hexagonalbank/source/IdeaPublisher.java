package com.hexagonalbank.source;

import com.hexagonalbank.channel.OutputChannel;
import com.hexagonalbank.model.Idea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.hexagonalbank.channel.OutputChannel.IDEA_OUTPUT;

@Component
@EnableBinding({com.hexagonalbank.channel.OutputChannel.class})
@Slf4j
public class IdeaPublisher {

    private Random random = new Random();

    @InboundChannelAdapter(channel = IDEA_OUTPUT, poller=@Poller(fixedDelay="2000"))
    public Message<Idea> submitIdea(){
        if(random.nextInt(10) % 2 == 0) {
            log.info("submitting first idea");
            Idea idea = new Idea();
            idea.setTitle("Java Script compiler");
            idea.setDescription("Java script compiler that compiles javascript to javascript");

            idea.setTeamSize(4);
            idea.setLocation("Bangalore");
            return this.publishIdea(idea);
        }

        if(random.nextInt(10) % 3 == 0) {
            log.info("submitting second idea");
            Idea idea = new Idea();
            idea.setTitle("Pascal Triangle");
            idea.setDescription("Develop an app to print Pascal triangle of size N");

            idea.setTeamSize(2);
            idea.setLocation("Chennai");
            return this.publishIdea(idea);
        }

        log.info("submitting third idea");
        Idea idea = new Idea();
        idea.setTitle("Load Web-page Images Slowly");
        idea.setDescription("Sometimes you just want to experience the thrill of a long page load." +
                " Give your users the chance to enjoy a little slice of the past by slow loading your website's images");
        idea.setTeamSize(5);
        idea.setLocation("Chennai");
        return this.publishIdea(idea);
    }


    public Message<Idea> publishIdea(Idea idea){

        Message<Idea> message =  MessageBuilder.
                withPayload(idea)
                .build();
        log.info("Publishing  idea - {} ", message);

        return  message;
    }

}











































//https://github.com/mikeal/vanilla