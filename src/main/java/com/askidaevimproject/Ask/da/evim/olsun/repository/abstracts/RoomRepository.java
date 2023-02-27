package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoomRepository  extends JpaRepository<Room,Long> {


    Room findByRoomType(String roomType);
}
