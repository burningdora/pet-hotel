package com.pethotel.pet_hotel;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomCacheService roomCacheService;

    public RoomController(RoomCacheService roomCacheService) {
        this.roomCacheService = roomCacheService;
    }

    @PostMapping("/{roomNumber}")
    public String setStatus(@PathVariable int roomNumber, @RequestParam String status) {
        roomCacheService.setRoomStatus(roomNumber, status);
        return "Статус номера " + roomNumber + " установлен: " + status;
    }

    @GetMapping("/{roomNumber}")
    public String getStatus(@PathVariable int roomNumber) {
        String status = roomCacheService.getRoomStatus(roomNumber);
        return status != null ? status : "Номер не найден";
    }

    @DeleteMapping("/{roomNumber}")
    public String deleteStatus(@PathVariable int roomNumber) {
        roomCacheService.deleteRoomStatus(roomNumber);
        return "Номер " + roomNumber + " освобождён";
    }
}
