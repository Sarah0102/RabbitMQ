package com.example.direct.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"direct","config"})
@Configuration
public class DirectConfig {
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("direct");
    }
    @Profile("receiver")
    private static class Reciver {
        @Bean
        public Queue queue1 () {
            return new AnonymousQueue();
        }
        @Bean
        public Queue queue2 () {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1a (DirectExchange direct, Queue queue1){
            return BindingBuilder.bind(queue1).to(direct).with("orange");
        }
        @Bean
        public  Binding binding1b (DirectExchange direct, Queue queue1){
            return BindingBuilder.bind(queue1).to(direct).with("black");
        }
        @Bean
        public Binding binding2a (DirectExchange direct, Queue queue2){
            return BindingBuilder.bind(queue2).to(direct).with("green");
        }
        @Bean
        public  Binding binding2b (DirectExchange direct, Queue queue2){
            return BindingBuilder.bind(queue2).to(direct).with("black");
        }
        @Bean
        public Receiver receiver(){
            return new Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Sender sender(){
        return new Sender();
    }
}
