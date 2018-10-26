package com.hexagonalbank.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputChannel {

    String ANNOUNCEMENT_OUTPUT = "announcementSubmissionChannel";
    @Output(ANNOUNCEMENT_OUTPUT)
    MessageChannel announcementSubmissionChannel();

    String REGISTRATION_OUTPUT = "registrationSubmissionChannel";
    @Output(REGISTRATION_OUTPUT)
    MessageChannel registrationSubmissionChannel();

    String IDEA_OUTPUT = "ideaSubmissionChannel";
    @Output(IDEA_OUTPUT)
    MessageChannel ideaSubmissionChannel();


    String PARTITION_OUTPUT = "partitionSubmissionChannel";
    @Output(PARTITION_OUTPUT)
    MessageChannel partitionSubmissionChannel();
}