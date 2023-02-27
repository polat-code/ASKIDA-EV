package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "fuel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fuel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="fuel_id")
    private Long fuel_id;


    @Column(name="fuel_type")
    private String fuelType;

}
