package com.askidaevimproject.Ask.da.evim.olsun.repository;

import com.askidaevimproject.Ask.da.evim.olsun.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByMemberMail(String member_mail);

}
