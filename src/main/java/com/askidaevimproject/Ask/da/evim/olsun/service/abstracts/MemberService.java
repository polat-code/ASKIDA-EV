package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberMailException;
import com.askidaevimproject.Ask.da.evim.olsun.exception.MemberNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;

import java.util.List;

public interface MemberService {

    List<GetAllMemberResponse> getAllMembers();

    void addMember(CreateMemberRequest createMemberRequest);

    void deleteMember(Long member_id);

    void updateMember(UpdateMemberRequest updateMemberRequest);


    GetByMemberIdResponse getByMemberId(Long member_id) throws MemberNotFoundException;

    GetByMemberMailResponse findByEmail(String member_mail) throws MemberMailException;
}
