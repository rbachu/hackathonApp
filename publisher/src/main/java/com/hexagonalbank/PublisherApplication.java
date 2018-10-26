package com.hexagonalbank;

import com.hexagonalbank.source.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hexagonalbank"}, excludeFilters = {
        @ComponentScan.Filter(type = ASSIGNABLE_TYPE, value =
                {
                        DemoPublisher.class,
                        AnnouncementPublisher.class,
                        RegistrationPublisher.class,
                        IdeaPublisher.class,
                        PartitionPublisher.class,
                })})
public class PublisherApplication {


    public static void main(String[] args) {

        run(PublisherApplication.class, new String[]{"\"--management.endpoints.web.expose=*\""});
    }


}
