package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static jakarta.persistence.GenerationType.*;

@Table(name="dwelling")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dwelling {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long dwelling_id;

   @ManyToOne
    @JoinColumn(
           name = "f_city_id",
           referencedColumnName = "city_id"
   )
    private City city;

    @OneToOne
    @JoinColumn(
            name = "f_district_id",
            referencedColumnName = "district_id"
    )
    private District district;

    @OneToOne
    @JoinColumn(
            name = "fk_neighborhood_id",
            referencedColumnName = "neighborhood_id"
    )
    private Neighborhood neighborhood;

    @OneToOne
    @JoinColumn(
            name = "fk_fuel_id",
            referencedColumnName = "fuel_id"
    )
    private Fuel fuel;



    @Column(name="description")
    private String description;
    @Column(name = "age_of_dwelling")
    private String ageOfDwelling;

    @Column(name="meter_square")
    private String meterSquare;

    @Column(name="is_activate")
    private int isActivate;









}