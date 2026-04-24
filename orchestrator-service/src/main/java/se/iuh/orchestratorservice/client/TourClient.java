package se.iuh.orchestratorservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.iuh.orchestratorservice.dto.Tour;

@Component
public class TourClient {

    private final RestTemplate restTemplate;

    public TourClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Tour getTour(Long tourId) {
        String url = "http://172.16.64.36:8082/tours/" + tourId;
        return restTemplate.getForObject(url, Tour.class);
    }
}
