package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDistrictResponse {

    @Column(name="district_id")
    private Long district_id;

    private GetAllCityResponse cityResponse;

    @Column(name="district_name")
    private String districtName;

}