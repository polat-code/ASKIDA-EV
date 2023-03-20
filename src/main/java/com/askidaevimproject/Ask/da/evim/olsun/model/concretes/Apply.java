package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="application")
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_id")
    private Long applicationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "applicant_id",
            referencedColumnName = "applicant_id")
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "advert_id",
            referencedColumnName = "advert_id"
    )
    private Advert advert;



    @Column(name="status")
    private int status;
}
