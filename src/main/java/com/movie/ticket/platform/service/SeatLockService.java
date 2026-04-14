package com.movie.ticket.platform.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SeatLockService {

    private Map<String, Long> locks = new ConcurrentHashMap<>();

    public String lockSeats(Long showId, List<String> seatIds) {
        String lockId = UUID.randomUUID().toString();

        seatIds.forEach(seat -> {
            locks.put(showId + "_" + seat, System.currentTimeMillis());
        });

        return lockId;
    }
}
