package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "neighborhood")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="neighborhood_id")
    private Long neighborhood_id;



    @Column(name = "neighborhood_name")
    private String neighborhood_name;

    @Column(name="zip_code")

    private String zip_code;
}