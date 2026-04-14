package com.movie.ticket.platform.controller;

import com.movie.ticket.platform.entity.Booking;
import com.movie.ticket.platform.entity.CreateBookingRequest;
import com.movie.ticket.platform.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Step 2: Create Booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody CreateBookingRequest request) {

        Booking booking = bookingService.createBooking(
                request.getUserId(),
                request.getShowId(),
                request.getAmount()
        );

        return ResponseEntity.ok(booking);
    }

    // Get User Bookings
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }
}
