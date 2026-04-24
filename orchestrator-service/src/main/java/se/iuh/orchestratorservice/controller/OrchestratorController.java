package se.iuh.orchestratorservice.controller;

// controller/OrchestratorController.java
import org.springframework.web.bind.annotation.*;
import se.iuh.orchestratorservice.dto.BookTourRequest;
import se.iuh.orchestratorservice.dto.BookTourResponse;
import se.iuh.orchestratorservice.service.BookingOrchestratorService;

@RestController
@RequestMapping("/")
public class OrchestratorController {

    private final BookingOrchestratorService service;

    public OrchestratorController(BookingOrchestratorService service) {
        this.service = service;
    }

    @PostMapping("/book-tour")
    public BookTourResponse bookTour(@RequestBody BookTourRequest request) {
        return service.bookTour(request);
    }
}
