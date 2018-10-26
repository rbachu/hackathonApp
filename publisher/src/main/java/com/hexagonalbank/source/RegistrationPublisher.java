package com.hexagonalbank.source;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.hexagonalbank.channel.OutputChannel.REGISTRATION_OUTPUT;

@Component
@EnableBinding({com.hexagonalbank.channel.OutputChannel.class})
@Slf4j
public class RegistrationPublisher {

    private Random random = new Random();

   @InboundChannelAdapter(channel = REGISTRATION_OUTPUT, poller=@Poller(fixedDelay="6000"))
    public String registerEmployee(){
        Integer id = random.nextInt(1000);
        String message = "{\"id\":\""+id+"\", \"name\":\""+"Emp-"+id+"\"}";
        log.info("Publish employee registration {} ", message);
        return message;
    }

}
