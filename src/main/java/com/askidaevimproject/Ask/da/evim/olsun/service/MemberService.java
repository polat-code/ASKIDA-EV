package com.askidaevimproject.Ask.da.evim.olsun.service;

import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberIsAlreadyTakenException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberMailException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class MemberService {

    private  MemberRepository memberRepository;

    public MemberService(){}
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member findByMember_mail(String member_mail) throws MemberNotFoundException {

        if(memberRepository.findByMemberMail(member_mail).getMemberMail().length()<0){
            throw new MemberNotFoundException("The member is not found with mail address ");
        }
        return memberRepository.findByMemberMail(member_mail);
    }

    public Member addMember(Member member) throws MemberIsAlreadyTakenException, MemberMailException {

        if(memberRepository.existsById(member.getMember_id())){
            throw new MemberIsAlreadyTakenException("The member is already using the system therefore we cannot put it into the database");
        }
        else
        {
            if(member.getMemberMail().contains("@") && member.getMember_password().length()>8)
            {
                member.setMember_photo("photo/memberPhoto/"+member.getMember_photo());
            }
            else{
                throw new MemberMailException("The mail address of user does not contain @ ");
            }
        }
        return memberRepository.save(member);
    }

    public void deleteMember(Long member_id) {


        if(memberRepository.existsById(member_id))
        {
            memberRepository.deleteById(member_id);
        }
    }

    public Member updateMember(Member member, Long member_id) {
        Member updatedMember = memberRepository.findById(member_id).get();
        if(memberRepository.existsById(updatedMember.getMember_id())
                && member.getMemberMail().contains("@")
                && member.getMember_password().length()>8)
        {
            updatedMember.setMemberMail(member.getMemberMail());
            updatedMember.setMember_name(member.getMember_name());
            updatedMember.setMember_address(member.getMember_address());
            updatedMember.setMember_password(member.getMember_password());
            /**
             * Hesab??n?? dondurmak isteyen/ silmek isteyen kullan??c??lar i??in ge??ici s??reli??ine kapat veya dondurmak
             * i??in is activate
             *
             * **/
            updatedMember.setIs_activate(member.getIs_activate());
            updatedMember.setMember_surname(member.getMember_surname());
            updatedMember.setMember_photo("photo/memberPhoto"+member.getMember_photo());
        }
        return memberRepository.save(updatedMember);
    }
}
