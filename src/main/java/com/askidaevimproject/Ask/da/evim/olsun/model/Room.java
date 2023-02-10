package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    @Id

    private Long room_id;


    private String room_type;


}
