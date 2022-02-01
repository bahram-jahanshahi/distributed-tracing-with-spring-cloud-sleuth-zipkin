package ser.clientservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
public class SendMessageService {

    private final RestTemplate restTemplate;

    private final String sendMessageUrl;

    public SendMessageService(Environment environment) {
        restTemplate = new RestTemplate();
        this.sendMessageUrl = Objects.requireNonNull(environment.getProperty("server-service.url")) + "/api/v1/message";
    }

    public void send(String message) {
        this.restTemplate.postForEntity(sendMessageUrl, message, String.class, Map.of());
    }
}
