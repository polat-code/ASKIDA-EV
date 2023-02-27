package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.MemberService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;


    @GetMapping("")
    public List<GetAllMemberResponse> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public GetByMemberIdResponse getByMemberId(@PathVariable Long member_id) throws MemberNotFoundException {
        return memberService.getByMemberId(member_id);

    }

    @GetMapping("/{member_mail}")
    public GetByMemberMailResponse getByMemberMail(@PathVariable String member_mail){
        return memberService.getByMemberMail(member_mail);
    }



    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMember(@RequestBody CreateMemberRequest createMemberRequest){
         memberService.addMember(createMemberRequest);
    }

    @DeleteMapping("/{member_id}")
    public void deleteMember(@PathVariable Long member_id){
        memberService.deleteMember(member_id);
    }

    @PutMapping("")
    public void updateMember(@RequestBody UpdateMemberRequest  updateMemberRequest){
        memberService.updateMember(updateMemberRequest);
    }
}
