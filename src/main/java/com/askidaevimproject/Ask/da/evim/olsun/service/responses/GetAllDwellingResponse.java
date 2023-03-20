package com.askidaevimproject.Ask.da.evim.olsun.service.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDwellingResponse {



    private Long dwelling_id;
    private String cityName;
    private String districtName;
    private String neighborhoodname;
    private String fuelType;
    private String description;
    private String ageOfDwelling;
    private String meterSquare;
    private String isActivate;

}
