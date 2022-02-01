package ser.clientservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ser.clientservice.services.SendMessageService;

@RestController
@RequestMapping("/api/v1/message")
public class SendMessageController {

    private final Environment environment;

    private final SendMessageService sendMessageService;

    private static final Logger logger  = LoggerFactory.getLogger(SendMessageController.class);

    private final String applicationName;

    public SendMessageController(Environment environment, SendMessageService sendMessageService) {
        this.environment = environment;
        this.sendMessageService = sendMessageService;
        applicationName = this.environment.getProperty("spring.application.name");
    }

    @PostMapping
    private ResponseEntity<String> sendMessage(@RequestBody String message) {
        logger.info("Incoming request at {} to send message", this.applicationName);
        this.sendMessageService.send(message);
        return ResponseEntity.ok("Your message is sent.");
    }
}
