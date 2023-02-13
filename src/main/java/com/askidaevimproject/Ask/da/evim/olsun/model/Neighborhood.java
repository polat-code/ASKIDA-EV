package com.askidaevimproject.Ask.da.evim.olsun.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long neighborhood_id;



    @Column(nullable = true)
    private String neighborhood_name;

    @Column(nullable = true)
    private String zip_code;
}
