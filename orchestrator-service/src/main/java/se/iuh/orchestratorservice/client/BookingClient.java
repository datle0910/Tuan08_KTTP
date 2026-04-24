package se.iuh.orchestratorservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.iuh.orchestratorservice.dto.BookTourRequest;
import se.iuh.orchestratorservice.dto.Booking;

@Component
public class BookingClient {

    private final RestTemplate restTemplate;

    public BookingClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Booking createBooking(BookTourRequest request) {
        String url = "http://172.16.64.86:8083/bookings";
        return restTemplate.postForObject(url, request, Booking.class);
    }
}