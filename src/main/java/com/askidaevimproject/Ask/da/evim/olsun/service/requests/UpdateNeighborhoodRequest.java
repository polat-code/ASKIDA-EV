package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNeighborhoodRequest {

    private Long neighborhood_id;
    private String zip_code;
    @Column(name="f_district_id")
    @JoinColumn(name="f_district_id")
    private CreateDistrictRequest createDistrictRequest;
    private String neighborhood_name;
}
