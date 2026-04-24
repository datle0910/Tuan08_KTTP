package se.iuh.orchestratorservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.iuh.orchestratorservice.dto.Payment;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentClient {

    private final RestTemplate restTemplate;

    public PaymentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment pay(Long bookingId) {
        String url = "http://192.168.1.14:8084/payments";

        // request đơn giản
        Map<String, Long> req = new HashMap<>();
        req.put("bookingId", bookingId);

        return restTemplate.postForObject(url, req, Payment.class);
    }
}