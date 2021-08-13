package com.example.workqueue.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"config", "work-queues"})
@Configuration
public class WorkQueueConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Profile("receiver")
    private static class ReceiverConfig {
        @Bean
        public Receiver receiver1() {
            return new Receiver(1);
        }
        @Bean
        public Receiver recevier2(){
            return new Receiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public static Sender sender(){
        return new Sender();
    }
}
