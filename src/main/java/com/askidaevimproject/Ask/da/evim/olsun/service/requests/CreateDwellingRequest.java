package com.askidaevimproject.Ask.da.evim.olsun.service.requests;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDwellingRequest {


    @ManyToOne
    @JoinColumn(
            name = "f_city_id",
            referencedColumnName = "city_id"
    )
    private CreateCityRequest city;

    @OneToOne
    @JoinColumn(
            name = "f_district_id",
            referencedColumnName = "district_id"
    )
    private CreateDistrictRequest district;

    @OneToOne
    @JoinColumn(
            name = "fk_neighborhood_id",
            referencedColumnName = "neighborhood_id"
    )
    private CreateNeighborhoodRequest neighborhood;

    @OneToOne
    @JoinColumn(
            name = "fk_fuel_id",
            referencedColumnName = "fuel_id"
    )
    private CreateFuelRequest fuel;



    @Column(name="description")
    private String description;
    @Column(name = "age_of_dwelling")
    private String ageOfDwelling;

    @Column(name="meter_square")
    private String meterSquare;

    @Column(name="is_activate")
    private int isActivate;




}
