package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.model.abstracts.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Applicant")
@Builder
public class Applicant implements Member {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="applicant_id")
    private Long applicantId;

    @Column(name="applicant_name")
    private String applicantName;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false,name = "role")

    private Role role = Role.USER;

    @Column(name="applicant_surname")
    private String applicantSurname;


    @Column(name="applicant_phone",unique = true)
    private String applicantPhone;


    /**  mail should be check contains
     * ( @ )
     * **/

    //@Email(regexp = )

    @Column(name="applicant_mail",unique = true)
    private String applicantMail;


    @Column(name="applicant_password")
    private String applicantPassword;






    @Column(name = "applicant_address")
    private String applicantAddress;




    /**
     * After verify it activate will be changed.When the user is registered is_Activate default 0
     * **/
    @Column(name="is_activate")
    private int isActivate;

}
