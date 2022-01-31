package se.bahram.cloudnative.serverservice.controllers;

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

    public ReceiveMessageController(ReceiveMessageService receiveMessageService) {
        this.receiveMessageService = receiveMessageService;
    }

    @PostMapping
    private ResponseEntity<String> receive(@RequestBody String message) {
        this.receiveMessageService.receive(message);
        return ResponseEntity.ok("Message is received.");
    }
}
