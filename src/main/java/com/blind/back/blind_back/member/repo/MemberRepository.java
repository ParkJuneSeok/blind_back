package com.blind.back.blind_back.member.repo;

import com.blind.back.blind_back.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Date : 2022-02-15
 **/
public interface MemberRepository extends JpaRepository<Member, Long> {

}
