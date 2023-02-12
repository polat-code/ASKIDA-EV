package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dwelling {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long dwelling_id;

    @ManyToOne
    @JoinColumn(
            name = "f_city_id",
            referencedColumnName = "city_id"
    )
    private City city;

    @OneToOne
    @JoinColumn(
            name = "f_district_id",
            referencedColumnName = "district_id"
    )
    private District district;






}
