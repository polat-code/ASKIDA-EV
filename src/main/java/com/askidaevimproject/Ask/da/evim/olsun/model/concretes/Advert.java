package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.*;


@Table(name="advert")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advert {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "advert_id")
    private Long advert_id;



    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "member_id",
                referencedColumnName = "member_id"
                )
    private Member member;

    @Column(name = "advert_title")
    private String advertTitle;
    @ManyToOne
    @JoinColumn(
            name = "city_id",
            referencedColumnName = "city_id"
    )
    private City city;

    @ManyToOne
    @JoinColumn(
            name = "district_id",
            referencedColumnName = "district_id"
    )
    private District district;

    @ManyToOne
    @JoinColumn(
            name = "neighborhood_id",
            referencedColumnName = "neighborhood_id"
    )
    private Neighborhood neighborhood;

    @ManyToOne
    @JoinColumn(
            name = "fuel_id",
            referencedColumnName = "fuel_id"
    )
    private Fuel fuel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "room_id",
            referencedColumnName = "room_id"
    )
    private Room room;


    @Column(name="description")
    private String description;

    @Column(name = "age_of_dwelling")
    private String ageOfDwelling;

    @Column(name="meter_square")
    private String meterSquare;

    @Column(name="is_activate")
    private int isActivate;

    @Column(name = "street")
    private String street;




}
