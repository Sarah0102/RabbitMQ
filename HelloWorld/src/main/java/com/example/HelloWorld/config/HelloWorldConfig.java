package com.example.HelloWorld.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"config","hello-world"})
@Configuration
public class HelloWorldConfig {

    @Bean
    public Queue hello(){
        return new Queue("hello");
    }
    @Profile("receiver")
    @Bean
    public Receiver receiver(){
        return new Receiver();
    }

    @Profile("sender")
    @Bean
    public Sender sender(){
        return new Sender();
    }
}
