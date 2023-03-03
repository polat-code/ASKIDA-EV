package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllMemberResponse {

    private String memberName;
    private String memberSurname;
    private String memberPhone;
    private String memberMail;
    private String memberAddress;

}
