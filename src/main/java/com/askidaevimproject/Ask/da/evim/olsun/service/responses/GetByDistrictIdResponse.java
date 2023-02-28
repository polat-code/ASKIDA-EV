package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByDistrictIdResponse {

    private String district_name;
    private GetAllCityResponse getAllCityResponse;
}