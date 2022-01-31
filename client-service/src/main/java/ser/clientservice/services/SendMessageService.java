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

    private final Environment environment;

    private final RestTemplate restTemplate;

    private static final Logger logger  = LoggerFactory.getLogger(SendMessageService.class);

    private final String applicationName;

    private final String sendMessageUrl;

    public SendMessageService(Environment environment) {
        this.environment = environment;
        restTemplate = new RestTemplateBuilder().build();
        applicationName = environment.getProperty("spring.application.name");
        this.sendMessageUrl = Objects.requireNonNull(environment.getProperty("server-service.url")) + "/api/v1/message";
    }

    public void send(String message) {
        logger.info("Incoming request at {} to send message", this.applicationName);
        this.restTemplate.postForEntity(sendMessageUrl, message, String.class, Map.of());
    }
}
