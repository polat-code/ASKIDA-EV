package com.askidaevimproject.Ask.da.evim.olsun.service.rules;


import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.RoomTypeExistsException;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoomBusinessRules {

    private RoomRepository roomRepository;

    public void checkIfRoomTypeExists(String room_type) throws RoomTypeExistsException {

        if(this.roomRepository.existsByRoomType(room_type))
             throw new RoomTypeExistsException("The room type is using");
    }


}
