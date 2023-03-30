package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdvertRequest {


    @NotNull
    @NotBlank
    private Long advertId;

    @NotBlank
    @NotNull
    @Size(min = 6)
    private String advert_title;

    @NotNull
    @NotBlank
    private Long cityId;

    @NotNull
    @NotBlank
    private Long districtId;

    @NotNull
    @NotBlank
    private Long neighborhoodId;

    @NotNull
    @NotBlank
    private Long fuelId;

    @NotNull
    @NotBlank
    private Long roomId;

    @NotNull
    @NotBlank
    private Long description;

    @NotNull
    @NotBlank
    private Long ageOfDwelling;

    @NotNull
    @NotBlank
    private Long meterSquare;

    @NotNull
    @NotBlank
    private Long isActivate;

    @NotNull
    @NotBlank
    private Long street;






}
