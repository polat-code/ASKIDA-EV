package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberIsAlreadyTakenException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberMailException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.MemberService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;
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


    public GetByMemberMailResponse findByEmail(String member_mail) throws MemberMailException {

        Member member = this.memberRepository.findByEmail(member_mail).orElseThrow(()->new MemberMailException("The mail address not found exception .. "));
        return  this.modelMapperService.forResponse().map(member,GetByMemberMailResponse.class);

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
}
