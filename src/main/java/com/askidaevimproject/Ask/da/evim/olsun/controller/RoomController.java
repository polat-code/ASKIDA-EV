package com.askidaevimproject.Ask.da.evim.olsun.controller;

import com.askidaevimproject.Ask.da.evim.olsun.exception.RoomContainedException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.RoomNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.Room;
import com.askidaevimproject.Ask.da.evim.olsun.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rooms")
@RestController
public class RoomController {

    private  RoomService roomService;
    public RoomController(){}

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public List<Room> getAllRoom(){

        return roomService.getAllRoom();

    }
    @PostMapping("/")
    public Room addRoom(@RequestBody Room room) throws RoomContainedException {
        return roomService.addRoom(room);
    }
    @DeleteMapping("/deleteRoom/{room_id}")
    public void deleteRoom(@PathVariable Long room_id){
        roomService.deleteRoom(room_id);
    }
    @PutMapping("/updateRoom/{room_id}")
    public Room updateRoom(@RequestBody Room room,@PathVariable Long room_id) throws RoomNotFoundException {
        return roomService.updateRoom(room,room_id);
    }

}
