package com.example.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class HelloWorldConfigRunner implements CommandLineRunner {
    @Value("${tutorial.client.duration:0}")
    private int duration;
    @Autowired
    private ConfigurableApplicationContext ctxt;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready....... running for " + duration +"ms");
        Thread.sleep(duration);
        ctxt.close();
    }
}
