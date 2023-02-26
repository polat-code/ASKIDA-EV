package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static jakarta.persistence.GenerationType.*;

@Table(name = "city")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="city_id")
    private Long city_id;

    @Column(name = "city_name")
    @NotBlank(message = "City name is required field please fill in the blank ")
    private String city_name;


}