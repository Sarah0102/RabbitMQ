package com.example.direct.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class Receiver {
    @RabbitListener(queues = "#{queue1.name}")
    public void receive1(String message) throws InterruptedException {
        receive(message,1);
    }
    @RabbitListener(queues = "#{queue2.name}")
    public void receive2(String message) throws InterruptedException {
        receive(message,2);
    }
    public void receive(String in, int receiver) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + receiver + " [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance " + receiver + " [x] Done in " +
                watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
