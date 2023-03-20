package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.RoomService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllRoomResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByRoomTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public void addRoom(@RequestBody() @Valid() CreateRoomRequest createRoomRequest)  {
        this.roomService.addRoom(createRoomRequest);
    }
    @DeleteMapping("/{room_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRoom(@PathVariable Long room_id){
        roomService.deleteRoom(room_id);
    }

    @PutMapping("")
    public void updateRoom(@RequestBody @Valid() UpdateRoomRequest updateRoomRequest) {
         roomService.updateRoom(updateRoomRequest);
    }

    @GetMapping(value="/roomType/{roomType}")
    public GetByRoomTypeResponse findByRoomType(@PathVariable String roomType){
        return this.roomService.findByRoomType(roomType);
    }





}
