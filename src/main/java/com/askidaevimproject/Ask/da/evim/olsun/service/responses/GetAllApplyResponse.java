package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllApplyResponse {

    private Long apply_id;
    private String member_name;
    private String member_surname;
    private String member_phone;

}
