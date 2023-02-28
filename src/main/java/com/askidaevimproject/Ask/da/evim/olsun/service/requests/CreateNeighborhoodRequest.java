package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNeighborhoodRequest {

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="f_district_id")
    @JoinColumn(name = "f_district_id")
    private CreateDistrictRequest createDistrictRequest;

    @Column(name="neighborhood_name")
    private String neighborhoodName;


}
