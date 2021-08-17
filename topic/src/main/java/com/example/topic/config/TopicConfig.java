package com.example.topic.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"config","topic"})
public class TopicConfig {
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topic");
    }
    @Profile("receiver")
    private static class RecevierConfig{
        @Bean
        public Queue queue1(){
            return new AnonymousQueue();
        }
        @Bean
        public Queue queue2(){
            return new AnonymousQueue();
        }
        @Bean
        public Binding binding1(TopicExchange exchange, Queue queue1 ){
            return BindingBuilder.bind(queue1).to(exchange).with("*.orange.*");
        }
        @Bean
        public Binding binding2(TopicExchange exchange, Queue queue2){
            return BindingBuilder.bind(queue2).to(exchange).with("*.*.rabbit");
        }
        @Bean
        public Binding bing3(TopicExchange exchange,Queue queue2){
            return BindingBuilder.bind(queue2).to(exchange).with("lazy.#");
        }
        @Bean
        public Receiver receiver(){
            return new Receiver();
        }
    }
    @Bean
    @Profile("sender")
    public Sender sender(){
        return new Sender();
    }


}
