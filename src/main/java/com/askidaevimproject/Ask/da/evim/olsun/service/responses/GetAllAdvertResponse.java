package com.askidaevimproject.Ask.da.evim.olsun.service.responses;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAdvertResponse {

    private String memberName;
    private String cityName;
    private String advertTitle;
}
