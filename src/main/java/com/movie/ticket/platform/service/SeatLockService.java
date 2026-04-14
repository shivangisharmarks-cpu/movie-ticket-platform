package com.movie.ticket.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
public class SeatLockService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final int LOCK_TTL = 300; // 5 min

    public String lockSeats(Long showId, List<String> seatIds) {
        String lockId = UUID.randomUUID().toString();

        for (String seat : seatIds) {
            String key = "lock:" + showId + ":" + seat;
            Boolean success = redisTemplate.opsForValue()
                    .setIfAbsent(key, lockId, Duration.ofSeconds(LOCK_TTL));

            if (Boolean.FALSE.equals(success)) {
                throw new RuntimeException("Seat already locked");
            }
        }
        return lockId;
    }
}
