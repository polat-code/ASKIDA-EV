package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.model.abstracts.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "benefactor")
public class Benefactor implements Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long benefactorId;

    @Column(name="benefactor_name")
    private String benefactorName;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false,name = "role")

    private Role role = Role.USER;

    @Column(name="benefactor_surname")
    private String benefactorSurname;


    @Column(name="benefactor_phone",unique = true)
    private String benefactorPhone;


    /**  mail should be check contains
     * ( @ )
     * **/

    //@Email(regexp = )

    @Column(name="benefactor_mail",unique = true)
    private String benefactorMail;


    @Column(name="benefactor_password")
    private String benefactorPassword;






    @Column(name = "benefactor_address")
    private String benefactorAddress;




    /**
     * After verify it activate will be changed.When the user is registered is_Activate default 0
     * **/
    @Column(name="is_activate")
    private int isActivate;



}
