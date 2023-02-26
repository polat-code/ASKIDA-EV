package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.exception.RoomContainedException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.RoomNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Room;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.RoomRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.RoomService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateRoomRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllRoomResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByRoomIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByRoomTypeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private ModelMapperService modelMapperService;


    public List<GetAllRoomResponse> getAllRoom() {
        List<Room> rooms = roomRepository.findAll();

        return rooms.
                stream()
                .map(room ->
                        this.modelMapperService.
                                forResponse().
                                map(room,GetAllRoomResponse.class)).toList();


    }

    public void addRoom(CreateRoomRequest createRoomRequest){

        Room room = this.modelMapperService.forRequest().map(createRoomRequest,Room.class);
        this.roomRepository.save(room);



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

    public void updateRoom(UpdateRoomRequest updateRoomRequest){

        Room room = this.modelMapperService.forRequest().map(updateRoomRequest,Room.class);
        this.roomRepository.save(room);
    }

    @Override
    public GetByRoomIdResponse findByRoom_id(Long room_id) throws RoomNotFoundException {
        Room room = this.roomRepository.findById(room_id).orElseThrow(()-> new RoomNotFoundException("The Room is not found exception"));
        return this.modelMapperService.forResponse().map(room,GetByRoomIdResponse.class);
    }



}
