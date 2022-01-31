package se.bahram.cloudnative.serverservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ReceiveMessageService {

    private final Environment environment;

    private static final Logger logger  = LoggerFactory.getLogger(ReceiveMessageService.class);

    private final String applicationName;

    public ReceiveMessageService(Environment environment) {
        this.environment = environment;
        applicationName = environment.getProperty("spring.application.name");
    }


    public void receive(String message) {
        logger.info("Incoming request at {} to receive message", this.applicationName);
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
