package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {


    Member findByMemberMail(String member_mail);

    Member findByMemberName(String member_name);

    boolean existsByMemberMail(String mail);

    boolean existsByMemberPhone(String phone);
}
