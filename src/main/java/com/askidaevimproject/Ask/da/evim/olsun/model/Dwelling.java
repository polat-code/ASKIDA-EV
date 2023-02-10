package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dwelling {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long dwelling_id;



}
