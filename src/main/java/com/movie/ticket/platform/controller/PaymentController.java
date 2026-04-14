package com.movie.ticket.platform.controller;

import com.movie.ticket.platform.entity.PaymentVerifyRequest;
import com.movie.ticket.platform.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/verify")
    public ResponseEntity<String> verifyPayment(@RequestBody PaymentVerifyRequest request) {

        // Simulate payment success
        bookingService.confirmBooking(request.getBookingId());

        return ResponseEntity.ok("Payment successful, booking confirmed");
    }
}
