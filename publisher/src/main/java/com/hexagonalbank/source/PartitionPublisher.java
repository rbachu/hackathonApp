package com.hexagonalbank.source;

import com.hexagonalbank.channel.OutputChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Random;


@Slf4j
@EnableBinding(OutputChannel.class)
public class PartitionPublisher {

        private static final Random RANDOM = new Random(System.currentTimeMillis());

        // We use a strategy so that this data will end up in a partition,
        // P = L(x) - 1 where L is a length function on the payload.
        private static final String[] data = new String[]{
                "f", "g", "h", //making them go to partition-0 by making a single char string
                "fo", "go", "ho",
                "foo", "goo", "hoo",
                "fooz", "gooz", "hooz"
        };

    private static final Integer[] numberData = new Integer[]{
            10, 20, 30, 40, 50, 60, 70,80,90,100
    };
        @InboundChannelAdapter(channel = OutputChannel.PARTITION_OUTPUT, poller = @Poller(fixedRate = "1000"))
        public Message<?> generate() {
            Integer value = numberData[RANDOM.nextInt(numberData.length)];

           /* return MessageBuilder.withPayload(value)
                    .setHeader("partitionKey", value.length())
                    .build();*/
           /*int teamSize = RANDOM.nextInt(100);*/
            log.info(" Partitioning publisher Sending: {}" , value);
           return MessageBuilder.withPayload(
                   "{\"word\":" + value +"}"
                   ).build();
        }
}