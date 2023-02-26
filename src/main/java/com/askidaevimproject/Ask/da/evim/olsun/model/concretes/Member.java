package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="member_id")

    private Long member_id;

    @Column(name="member_name")

    private String member_name;


    @Column(name="member_surname")

    private String member_surname;


    @Column(name="member_phone")

    private String member_phone;


    /**  mail should be check contains
     * ( @ )
     * **/

    @Column(name="member_mail")
    private String member_mail;


    @Column(name="member_password")

    private String member_password;


    @Lob
    @Column(name="member_photo")
    private String member_photo;

    @Lob
    @Column(name = "member_address")
    private String member_address;




    /**
     * After verify it activate will be changed.When the user is registered is_Activate default 0
     * **/
    @Column(name="is_activate")
    private int is_activate;


}
