package se.bahram.cloudnative.serverservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.bahram.cloudnative.serverservice.services.ReceiveMessageService;

@RestController
@RequestMapping("api/v1/message")
public class ReceiveMessageController {

    private final ReceiveMessageService receiveMessageService;

    private final Environment environment;

    private static final Logger logger  = LoggerFactory.getLogger(ReceiveMessageService.class);

    private final String applicationName;


    public ReceiveMessageController(ReceiveMessageService receiveMessageService, Environment environment) {
        this.receiveMessageService = receiveMessageService;
        this.environment = environment;
        applicationName = environment.getProperty("spring.application.name");
    }

    @PostMapping
    private ResponseEntity<String> receive(@RequestBody String message) {
        logger.info("Incoming request at {} to receive message", this.applicationName);
        this.receiveMessageService.receive(message);
        return ResponseEntity.ok("Message is received.");
    }
}
