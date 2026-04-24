package se.iuh.orchestratorservice.client;

// client/UserClient.java
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.iuh.orchestratorservice.dto.User;

@Component
public class UserClient {

    private final RestTemplate restTemplate;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUser(Long userId) {
        String url = "http://172.16.32.93:8081/users/" + userId;
        return restTemplate.getForObject(url, User.class);
    }
}
