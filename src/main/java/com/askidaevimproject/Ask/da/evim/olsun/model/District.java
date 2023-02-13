package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long district_id;

//    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
//    @JoinColumn(
//            name = "f_city_id", // add f_ tag to show
//            referencedColumnName = "city_id"
//    )
//    private City city;

    private String district_name;
}
