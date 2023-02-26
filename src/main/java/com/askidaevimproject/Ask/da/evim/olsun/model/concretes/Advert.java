package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.model.Dwelling;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "dwelling_id")
    private Dwelling dwelling;


    @Column(name = "advert_title")
    @NotBlank(message = "Advert Title may not be blank ")
    private String advert_title;


}