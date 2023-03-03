package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    private String memberName;


    @Column(name="member_surname")

    private String memberSurname;


    @Column(name="member_phone",unique = true)

    private String memberPhone;


    /**  mail should be check contains
     * ( @ )
     * **/

    //@Email(regexp = )

    @Column(name="member_mail",unique = true)
    private String memberMail;


    @Column(name="member_password")

    private String memberPassword;



    @Column(name="member_photo")
    private String memberPhoto;



    @Column(name = "member_address")
    private String memberAddress;




    /**
     * After verify it activate will be changed.When the user is registered is_Activate default 0
     * **/
    @Column(name="is_activate")
    private int isActivate;


}
