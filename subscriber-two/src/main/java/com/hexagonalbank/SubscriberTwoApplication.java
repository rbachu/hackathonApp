package com.hexagonalbank;

import com.hexagonalbank.sink.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.context.annotation.FilterType.*;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hexagonalbank"}, excludeFilters = {
        @Filter(type = ASSIGNABLE_TYPE, value =
                {
                        //IdeaSubscriber.class,
                        PartitionSubscriber.class
                })})
public class SubscriberTwoApplication {

    public static void main(String[] args) {
        run(SubscriberTwoApplication.class);
    }
}
