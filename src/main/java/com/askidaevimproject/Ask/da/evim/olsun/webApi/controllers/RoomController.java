package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.exception.RoomNotFoundException;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.RoomService;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllRoomResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByRoomIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByRoomTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/rooms")
@RestController
@AllArgsConstructor
public class RoomController {

    private RoomService roomService;


    @GetMapping("")
    public List<GetAllRoomResponse> getAllRoom(){

        return roomService.getAllRoom();

    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRoom(@RequestBody CreateRoomRequest createRoomRequest){
        roomService.addRoom(createRoomRequest);
    }
    @DeleteMapping("/{room_id}")
    public void deleteRoom(@PathVariable Long room_id){
        roomService.deleteRoom(room_id);
    }

    @PutMapping("/{room_id}")
    public void updateRoom(@RequestBody UpdateRoomRequest updateRoomRequest) {
         roomService.updateRoom(updateRoomRequest);
    }

    @GetMapping("/{room_id}")
    public GetByRoomIdResponse findByRoom_id(@PathVariable Long room_id) throws RoomNotFoundException {
        return roomService.findByRoom_id(room_id);
    }

    @GetMapping("/{room_type}")
    public GetByRoomTypeResponse findByRoom_type(@PathVariable String room_type) throws RoomNotFoundException {
        return roomService.findByRoom_type(room_type);
    }

}
