package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDistrictRequest {

    private Long district_id;
    @Column(name="f_city_id")
    @JoinColumn(name="f_city_id")
    private CreateCityRequest createCityRequest;
    private String district_name;
}
