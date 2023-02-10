package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="fuel_id")
    private Long fuel_id;

    @Column(name = "fuel_type")
    private String fuel_type;

}
