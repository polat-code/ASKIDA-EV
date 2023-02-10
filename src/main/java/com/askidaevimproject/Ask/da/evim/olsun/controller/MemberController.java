package com.askidaevimproject.Ask.da.evim.olsun.controller;

import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberIsAlreadyTakenException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberMailException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.Member;
import com.askidaevimproject.Ask.da.evim.olsun.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")

public class MemberController {

    private  MemberService memberService;

    public MemberController(){}
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }
    @GetMapping("/{member_mail}")
    public Member findByMember_mail(@PathVariable String member_mail) throws MemberNotFoundException {
        return memberService.findByMember_mail(member_mail);
    }

    @PostMapping("/")
    public Member addMember(@RequestBody Member member) throws MemberIsAlreadyTakenException, MemberMailException {
        return memberService.addMember(member);
    }

    @DeleteMapping("/deleteMember/{member_id}")
    public void deleteMember(@PathVariable Long member_id){
        memberService.deleteMember(member_id);
    }
    @PutMapping("/updateMember/{member_id}")
    public Member updateMember(@RequestBody Member member,@PathVariable(name = "member_id") Long member_id){
        return memberService.updateMember(member,member_id);
    }
}
