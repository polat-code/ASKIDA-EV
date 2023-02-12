package com.askidaevimproject.Ask.da.evim.olsun.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long neighborhood_id;

}
