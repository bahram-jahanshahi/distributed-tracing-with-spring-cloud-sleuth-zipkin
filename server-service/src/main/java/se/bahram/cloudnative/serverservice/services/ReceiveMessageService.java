package se.bahram.cloudnative.serverservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
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
