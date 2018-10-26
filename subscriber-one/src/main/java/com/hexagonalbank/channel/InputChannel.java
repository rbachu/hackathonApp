package com.hexagonalbank.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface InputChannel {


    String ANNOUNCEMENT_INPUT = "announcementSubscriptionChannel";
    @Input(ANNOUNCEMENT_INPUT)
    MessageChannel announcementSubscriptionChannel();

    String MEDIA_INPUT = "mediaSubscriptionChannel";
    @Input(MEDIA_INPUT)
    MessageChannel mediaSubscriptionChannel();

    String REGISTRATION_INPUT = "registrationSubscriptionChannel";
    @Input(REGISTRATION_INPUT)
    MessageChannel registrationSubscriptionChannel();


    String ORGANIZER_INPUT = "organizerSubscriptionChannel";
    @Input(ORGANIZER_INPUT)
    MessageChannel organizerSubscriptionChannel();

    String IDEA_INPUT = "ideaSubscriptionChannel";
    @Input(IDEA_INPUT)
    MessageChannel ideaSubscriptionChannel();

    String IDEA_PROCESSED_INPUT = "processedIdeaSubscriptionChannel";
    @Input(IDEA_PROCESSED_INPUT)
    MessageChannel processedIdeaSubscriptionChannel();

    String PARTITION_INPUT = "partitionSubscriptionChannel";
    @Input(PARTITION_INPUT)
    MessageChannel partitionSubscriptionChannel();


}