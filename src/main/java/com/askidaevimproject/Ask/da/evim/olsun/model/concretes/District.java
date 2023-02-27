package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.*;


@Table(name="district")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="district_id")
    private Long district_id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(
               name = "f_city_id", // add f_ tag to show
              referencedColumnName = "city_id"
    )
    private City city;

    @Column(name="district_name")
    private String districtName;
}