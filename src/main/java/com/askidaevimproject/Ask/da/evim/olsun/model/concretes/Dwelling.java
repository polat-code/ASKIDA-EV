package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dwelling {

    @Id
    private Long dwelling_id;



}
