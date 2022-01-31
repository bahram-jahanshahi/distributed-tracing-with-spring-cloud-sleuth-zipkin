package ser.clientservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ser.clientservice.services.SendMessageService;

@RestController
@RequestMapping("/api/v1/message")
public class SendMessageController {

    private final SendMessageService sendMessageService;

    public SendMessageController(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @PostMapping
    private ResponseEntity<String> sendMessage(@RequestBody String message) {
        this.sendMessageService.send(message);
        return ResponseEntity.ok("Your message is sent.");
    }
}
