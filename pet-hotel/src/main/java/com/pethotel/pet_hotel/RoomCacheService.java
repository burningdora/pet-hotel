package com.pethotel.pet_hotel;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RoomCacheService {

    private final StringRedisTemplate redisTemplate;

    public RoomCacheService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setRoomStatus(int roomNumber, String status) {
        redisTemplate.opsForValue().set("room:" + roomNumber, status);
    }

    public String getRoomStatus(int roomNumber) {
        return redisTemplate.opsForValue().get("room:" + roomNumber);
    }

    public void deleteRoomStatus(int roomNumber) {
        redisTemplate.delete("room:" + roomNumber);
    }
}
