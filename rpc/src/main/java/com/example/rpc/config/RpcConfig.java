package com.example.rpc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"config", "rpc"})
public class RpcConfig {
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("rpc");
    }

    @Profile("client")
    private static class ClientConfig {
        @Bean
        public Client client() {
            return new Client();
        }
    }

    @Profile("server")
    private static class ServerConfig {
        @Bean
        public Queue queue() {
            return new Queue("rpc.request");
        }

        @Bean
        public Binding binding(DirectExchange exchange, Queue queue) {
            return BindingBuilder.bind(queue).to(exchange).with("rpc");
        }

        @Bean
        public Server server() {
            return new Server();
        }
    }

}
