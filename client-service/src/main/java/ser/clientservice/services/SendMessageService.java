package ser.clientservice.services;

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

    public SendMessageService(Environment environment) {
        this.environment = environment;
        restTemplate = new RestTemplateBuilder().build();
    }

    public void send(String message) {
        String url = Objects.requireNonNull(environment.getProperty("server-service.url")) + "/api/v1/message";
        this.restTemplate.postForEntity(url, message, String.class, Map.of());
    }
}
