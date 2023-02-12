package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;
    private String room_type;

}
