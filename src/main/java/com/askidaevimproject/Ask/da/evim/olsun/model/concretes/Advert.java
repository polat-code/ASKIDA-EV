package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.*;


@Table(name="advert")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advert {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "advert_id")
    private Long advert_id;


    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "dwelling_id",
        referencedColumnName = "dwelling_id")
    private Dwelling dwelling;


    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "member_id",
                referencedColumnName = "member_id"
                )
    private Member member;

    @Column(name = "advert_title")
    private String advertTitle;


}
