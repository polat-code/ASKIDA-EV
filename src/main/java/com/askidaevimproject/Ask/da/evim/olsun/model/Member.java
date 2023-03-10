package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;


    private String member_name;


    private String member_surname;


    private String member_phone;


    /**  mail should be check contains
     * ( @ )
     * **/

    private String memberMail;


    private String member_password;


    @Lob
    private String member_photo;

    @Lob

    private String member_address;

    /**
     * After verify it activate will be changed.When the user is registered is_Activate default 0
     * **/
    private int is_activate;


}
