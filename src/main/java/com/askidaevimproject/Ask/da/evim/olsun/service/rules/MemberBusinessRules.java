package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.MemberMailException;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.MemberNameNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.MemberPhoneException;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MemberBusinessRules {

    private MemberRepository memberRepository;

    public void checkIfMemberMailExists(String mail) {

        if(this.memberRepository.existsByMemberMail(mail)){
            throw new MemberMailException("The mail address is already taken . ");
        }
    }

    public void checkIfMemberPhoneExists(String phone){
        if(this.memberRepository.existsByMemberPhone(phone))
            throw new MemberPhoneException("The phone number is using ");
    }
    public void checkIfMemberNameExists(String memberName){
        if(!(this.memberRepository.existsByMemberName(memberName))){
            throw new MemberNameNotFoundException("The member name is not matched any member please check entered member name ");
        }
    }







}
