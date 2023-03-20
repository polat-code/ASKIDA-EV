package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;


import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Applicant;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.MemberService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberNameResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.rules.MemberBusinessRules;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private  MemberRepository memberRepository;
    private ModelMapperService modelMapperService;

    private MemberBusinessRules memberBusinessRules;


    @Override
    public List<GetAllMemberResponse> getAllMembers()
    {
        List<Applicant> members = memberRepository.findAll();
        return members.
                stream()
                .map(member ->
                        this.modelMapperService.
                                forResponse().
                                map(member,GetAllMemberResponse.class)).toList();
    }

    @Override
    public void addMember(@NotNull CreateMemberRequest createMemberRequest) {

        this.memberBusinessRules.checkIfMemberMailExists(createMemberRequest.getMemberMail());
        this.memberBusinessRules.checkIfMemberPhoneExists(createMemberRequest.getMemberPhone());

       Applicant member=this.modelMapperService.forRequest().map(createMemberRequest, Applicant.class);

       this.memberRepository.save(member);

    }





    public void deleteMember(Long member_id) {

        if(memberRepository.existsById(member_id))
        {
            memberRepository.deleteById(member_id);
        }
    }

    public void updateMember(UpdateMemberRequest updateMemberRequest) {

        this.memberBusinessRules.checkIfMemberMailExists(updateMemberRequest.getMemberMail());
        this.memberBusinessRules.checkIfMemberPhoneExists(updateMemberRequest.getMemberPhone());
        Applicant member = this.modelMapperService.forRequest().map(updateMemberRequest, Applicant.class);
        this.memberRepository.save(member);


    }

    @Override
    public GetByMemberIdResponse getByMemberId(Long member_id)  {


        this.memberBusinessRules.checkIfMemberIdExists(member_id);
        Applicant member = this.memberRepository.findById(member_id).orElseThrow();
        return this.modelMapperService.forResponse().map(member,GetByMemberIdResponse.class);
    }

    @Override
    public GetByMemberMailResponse getByMemberMail(String member_mail) {


        Applicant member = this.memberRepository.findByMemberMail(member_mail);
        return this.modelMapperService.forResponse().map(member,GetByMemberMailResponse.class);
    }

    @Override
    public GetByMemberNameResponse getByMemberName(String member_name) {
        this.memberBusinessRules.checkIfMemberNameExists(member_name);
        Applicant member = this.memberRepository.findByMemberName(member_name);
        return this.modelMapperService.forResponse().map(member,GetByMemberNameResponse.class);
    }
}
