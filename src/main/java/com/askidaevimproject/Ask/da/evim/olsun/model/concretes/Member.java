package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
@Builder
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="member_id")

    private Long member_id;

    @Column(name="member_name")

    private String memberName;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false)
    private Role role = Role.USER;

    @Column(name="member_surname")

    private String memberSurname;


    @Column(name="member_phone",unique = true)

    private String memberPhone;


    /**  mail should be check contains
     * ( @ )
     * **/

    //@Email(regexp = )

    @Column(name="member_mail",unique = true)
    private String memberMail;


    @Column(name="member_password")

    private String memberPassword;



    @Column(name="member_photo")
    private String memberPhoto;



    @Column(name = "member_address")
    private String memberAddress;




    /**
     * After verify it activate will be changed.When the user is registered is_Activate default 0
     * **/
    @Column(name="is_activate")
    private int isActivate;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.memberMail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
