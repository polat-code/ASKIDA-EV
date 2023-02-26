package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoomRepository  extends JpaRepository<Room,Long> {

    Optional<Room> findByRoom_id(Long room_id);

}
