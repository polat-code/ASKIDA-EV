package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByMemberMailResponse {

    private String member_name;
    private String member_surname;
    private String member_phone;
    private String member_address;
}
