package com.hexagonalbank.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface InputChannel {

    String IDEA_PROCESSED_INPUT = "processedIdeaSubscriptionChannel";
    @Input(IDEA_PROCESSED_INPUT)
    MessageChannel processedIdeaSubscriptionChannel();

    String PARTITION_INPUT = "partitionSubscriptionChannel";
    @Input(PARTITION_INPUT)
    MessageChannel partitionSubscriptionChannel();


}