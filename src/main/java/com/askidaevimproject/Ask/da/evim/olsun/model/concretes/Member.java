package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    private Long member_id;


    private String member_name;


    private String member_surname;


    private String member_phone;


    /**  mail should be check contains
     * ( @ )
     * **/

    private String member_mail;


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
