package com.hexagonalbank.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputChannel {


    String IDEA_PROCESSED_OUTPUT = "processedIdeaSubmissionChannel";
    @Output(IDEA_PROCESSED_OUTPUT)
    MessageChannel processedIdeaSubmissionChannel();
}