package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dwelling_photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dphoto_id")
    private Long dphotoId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dwelling_id",
                referencedColumnName = "dwelling_id")
    private Dwelling dwelling;



    /* Another fields about photo !
    *  This code will be written with controller and service layers.
    *
    *
    * * */


}
