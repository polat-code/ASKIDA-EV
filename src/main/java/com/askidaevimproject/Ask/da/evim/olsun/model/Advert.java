package com.askidaevimproject.Ask.da.evim.olsun.model;

import javax.persistence.Id;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import static jakarta.persistence.FetchType.LAZY;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advert {


    @Id
    private Long advert_id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "dwelling_id")
    private Dwelling dwelling;


    private String advert_title;


}
