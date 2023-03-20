package com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Applicant,Long> {


    Applicant findByMemberMail(String member_mail);

    Applicant findByMemberName(String member_name);

    boolean existsByMemberMail(String mail);

    boolean existsByMemberPhone(String phone);

    boolean existsByMemberName(String memberName);
}
