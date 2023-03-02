package com.askidaevimproject.Ask.da.evim.olsun.service.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNeighborhoodRequest {

    @NotNull
    @NotBlank
    private String zipCode;

    @NotNull
    @NotBlank
    private Long districtId;

    @NotNull
    @NotBlank
    private String neighborhoodName;


}
