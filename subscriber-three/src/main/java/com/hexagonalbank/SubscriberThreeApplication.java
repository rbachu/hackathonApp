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
                        //PartitionSubscriber.class
                })})
public class SubscriberThreeApplication {

    public static void main(String[] args) {
        run(SubscriberThreeApplication.class);
    }
}
