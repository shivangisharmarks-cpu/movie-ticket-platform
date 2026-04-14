package com.movie.ticket.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    @GetMapping
    public ResponseEntity<String> getShows(
            @RequestParam String city,
            @RequestParam Long movieId) {

        return ResponseEntity.ok("List of shows for movie " + movieId + " in " + city);
    }

    @GetMapping("/{showId}/seats")
    public ResponseEntity<String> getSeats(@PathVariable Long showId) {

        return ResponseEntity.ok("Seat layout with availability for show " + showId);
    }
}
