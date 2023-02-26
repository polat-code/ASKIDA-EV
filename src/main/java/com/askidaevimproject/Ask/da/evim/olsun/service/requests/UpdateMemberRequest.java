package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateMemberRequest {


    private Long member_id;
    private String member_name;
    private String member_surname;
    private String member_phone;
    private String member_mail;
    private String member_password;
    private String member_photo;
    private String member_address;
    private int is_activate;


}
