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
           name = "city_id",
           referencedColumnName = "city_id"
   )
    private City city;

    @ManyToOne
    @JoinColumn(
            name = "district_id",
            referencedColumnName = "district_id"
    )
    private District district;

    @ManyToOne
    @JoinColumn(
            name = "neighborhood_id",
            referencedColumnName = "neighborhood_id"
    )
    private Neighborhood neighborhood;

    @ManyToOne
    @JoinColumn(
            name = "fuel_id",
            referencedColumnName = "fuel_id"
    )
    private Fuel fuel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "room_id",
            referencedColumnName = "room_id"
              )
    private Room room;
    /*
    * ROOM EKLENECEK RELATİONLAR DÜZENLENECEK
    *
    * */

    @Column(name="description")
    private String description;
    @Column(name = "age_of_dwelling")
    private String ageOfDwelling;

    @Column(name="meter_square")
    private String meterSquare;

    @Column(name="is_activate")
    private int isActivate;

    @Column(name = "street")
    private String street;







}