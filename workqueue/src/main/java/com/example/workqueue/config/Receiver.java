package com.example.workqueue.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "hello")
public class Receiver {
    private int instance;
    public Receiver(int instance){
        this.instance = instance;
    }

    @RabbitHandler
    public void receive(String message) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + this.instance +
                " [x] Received '" + message + "'");
        dock(message);
        watch.stop();
        System.out.println("instance " + this.instance +
                " [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }
    private void dock(String message) throws InterruptedException {
        for(char c: message.toCharArray()){
            if(c == '.'){
                Thread.sleep(1000);
            }
        }
    }
}
