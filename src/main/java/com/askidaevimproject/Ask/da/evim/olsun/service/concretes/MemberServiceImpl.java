package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exception.MemberNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.MemberService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private  MemberRepository memberRepository;
    private ModelMapperService modelMapperService;


    public List<GetAllMemberResponse> getAllMembers()
    {
        List<Member> members = memberRepository.findAll();
        return members.
                stream()
                .map(member ->
                        this.modelMapperService.
                                forResponse().
                                map(member,GetAllMemberResponse.class)).toList();
    }

    @Override
    public void addMember(CreateMemberRequest createMemberRequest) {
       Member member=this.modelMapperService.forRequest().map(createMemberRequest,Member.class);

       this.memberRepository.save(member);

    }





    public void deleteMember(Long member_id) {

        if(memberRepository.existsById(member_id))
        {
            memberRepository.deleteById(member_id);
        }
    }

    public void updateMember(UpdateMemberRequest updateMemberRequest) {

        Member member = this.modelMapperService.forRequest().map(updateMemberRequest,Member.class);
        this.memberRepository.save(member);


    }

    @Override
    public GetByMemberIdResponse getByMemberId(Long member_id) throws MemberNotFoundException {
        Member member = this.memberRepository.findById(member_id).orElseThrow(()-> new MemberNotFoundException("The member is not found "));
        return this.modelMapperService.forResponse().map(member,GetByMemberIdResponse.class);
    }

    @Override
    public GetByMemberMailResponse getByMemberMail(String member_mail) {
        Member member = this.memberRepository.findByMemberMail(member_mail);
        return this.modelMapperService.forResponse().map(member,GetByMemberMailResponse.class);
    }

    @Override
    public GetByMemberNameResponse getByMemberName(String member_name) {
        Member member = this.memberRepository.findByMemberName(member_name);
        return this.modelMapperService.forResponse().map(member,GetByMemberNameResponse.class);
    }
}
