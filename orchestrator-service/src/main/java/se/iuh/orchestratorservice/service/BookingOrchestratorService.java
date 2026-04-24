package se.iuh.orchestratorservice.service;

// service/BookingOrchestratorService.java
import org.springframework.stereotype.Service;
import se.iuh.orchestratorservice.client.BookingClient;
import se.iuh.orchestratorservice.client.PaymentClient;
import se.iuh.orchestratorservice.client.TourClient;
import se.iuh.orchestratorservice.client.UserClient;
import se.iuh.orchestratorservice.dto.*;

@Service
public class BookingOrchestratorService {

    private final UserClient userClient;
    private final TourClient tourClient;
    private final BookingClient bookingClient;
    private final PaymentClient paymentClient;

    public BookingOrchestratorService(
            UserClient userClient,
            TourClient tourClient,
            BookingClient bookingClient,
            PaymentClient paymentClient) {
        this.userClient = userClient;
        this.tourClient = tourClient;
        this.bookingClient = bookingClient;
        this.paymentClient = paymentClient;
    }

    public BookTourResponse bookTour(BookTourRequest request) {

        try {
            // 1. Validate user
            User user = userClient.getUser(request.getUserId());
            if (user == null) {
                return new BookTourResponse("FAIL", "User not found", null);
            }

            // 2. Get tour
            Tour tour = tourClient.getTour(request.getTourId());
            if (tour == null) {
                return new BookTourResponse("FAIL", "Tour not found", null);
            }

            // 3. Create booking
            Booking booking = bookingClient.createBooking(request);

            // 4. Payment
            Payment payment = paymentClient.pay(booking.id);

            if ("SUCCESS".equals(payment.status)) {
                return new BookTourResponse(
                        "SUCCESS",
                        "Booking successful",
                        booking.id
                );
            } else {
                return new BookTourResponse(
                        "FAIL",
                        "Payment failed",
                        booking.id
                );
            }

        } catch (Exception e) {
            return new BookTourResponse(
                    "ERROR",
                    "System error: " + e.getMessage(),
                    null
            );
        }
    }
}
