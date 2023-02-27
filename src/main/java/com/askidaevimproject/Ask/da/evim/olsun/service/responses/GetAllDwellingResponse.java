package com.askidaevimproject.Ask.da.evim.olsun.service.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDwellingResponse {

    private Long dwelling_id;
    private GetAllCityResponse cityResponse;
    private GetAllDistrictResponse getAllDistrictResponse;
    private GetAllNeighBorHoodResponse neighBorHoodResponse;
    private GetAllFuelResponse fuelResponse;
    private String description;
    private String ageOfDwelling;
    private String meterSquare;
    private String isActivate;

}
