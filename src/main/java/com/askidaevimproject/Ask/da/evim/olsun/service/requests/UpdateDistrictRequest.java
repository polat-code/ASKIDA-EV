package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDistrictRequest {

    private Long district_id;
    private CreateCityRequest createCityRequest;
    private String district_name;
}
