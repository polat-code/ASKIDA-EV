package com.askidaevimproject.Ask.da.evim.olsun.service;

import com.askidaevimproject.Ask.da.evim.olsun.exception.RoomContainedException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.RoomNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.Room;
import com.askidaevimproject.Ask.da.evim.olsun.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RoomService {

    private  RoomRepository roomRepository;


    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    public Room addRoom(Room room) throws RoomContainedException {

        List<Room> allRooms = getAllRoom();


        try {
            if (allRooms.contains(room)) {
                log.warn("This Room is contained already database , so we can not insert the room . Room Id : {}", room.getRoom_id());
                return null;
            }
        }
        catch (Exception e){
            throw new RoomContainedException(e.getMessage());
        }

        return roomRepository.save(room);

    }

    public void deleteRoom(Long room_id){

        if(roomRepository.existsById(room_id)){
            roomRepository.deleteById(room_id);
            /**
             * Silinen Id'ye ait dwelling'te ki room_id'yi NULL'A çevir.
             *
             * */
        }
    }

    public Room updateRoom(Room room,Long room_id) throws RoomNotFoundException {
        Room updatedRoom = roomRepository.findById(room_id).get();

        if(roomRepository.existsById(updatedRoom.getRoom_id()) &&
                !(updatedRoom.getRoom_type().equals(room.getRoom_type())))

            updatedRoom.setRoom_type(room.getRoom_type());

        else
            throw new RoomNotFoundException("The room is not found");

        return roomRepository.save(updatedRoom);
    }







}
