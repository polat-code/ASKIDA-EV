package com.askidaevimproject.Ask.da.evim.olsun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long advert_id;

    @ManyToOne
    @JoinColumn(name="member_id")
    @Column(nullable = false)
    private Member member;

    @OneToOne
    @JoinColumn(name = "dwelling_id")
    @Column(nullable = false)
    private Dwelling dwelling;

    @Column(name="advert_title",nullable = false)
    private String advert_title;


}
