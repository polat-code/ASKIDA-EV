package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.*;


@Entity
@Table(name = "neighborhood")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="neighborhood_id")
    private Long neighborhood_id;

    @Column(name = "neighborhood_name")
    private String neighborhoodName;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(
            name = "f_district_id", // add f_ tag to show
            referencedColumnName = "district_id"
    )
    private District district;

    @Column(name="zip_code")

    private String zipCode;
}