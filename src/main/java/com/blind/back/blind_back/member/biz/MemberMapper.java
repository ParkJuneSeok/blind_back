package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    int checkerMemId(MemberVO mvo);
    int insert(MemberVO mvo);
    MemberVO searchMember(MemberVO mvo);

    Optional<MemberVO> findByMemId(String memId);
    MemberVO findByEmailAndPassword(MemberVO mvo);
}
