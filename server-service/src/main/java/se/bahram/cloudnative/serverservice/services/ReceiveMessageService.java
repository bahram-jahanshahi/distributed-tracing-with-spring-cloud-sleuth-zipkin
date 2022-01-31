package se.bahram.cloudnative.serverservice.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ReceiveMessageService {

    public void receive(String message) {
        delay();
    }

    private void delay() {
        int delayTime = new Random().nextInt(500) + 500;
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
