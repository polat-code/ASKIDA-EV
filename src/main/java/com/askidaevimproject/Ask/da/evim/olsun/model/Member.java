package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="member_id")
    private Long member_id;

    @Column(name="member_name")
    private String member_name;

    @Column(name="member_surname")
    private String member_surname;

    @Column(name="member_phone")
    private String member_phone;

    @Column(name="member_mail")
    /**  mail should be check contains
     * ( @ )
     * **/

    private String member_mail;

    @Column(name="member_password")
    private String member_password;


    @Lob
    @Column(name="member_photo")
    private String member_photo;

    @Lob
    @Column(name="member_address")
    private String member_address;


    @Column(name="is_activate")

    /**
     * After verify it activate will be changed.When the user is registered is_Activate default 0
     * **/
    private int is_activate;


}
