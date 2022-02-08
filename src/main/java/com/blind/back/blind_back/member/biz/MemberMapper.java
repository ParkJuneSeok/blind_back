package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int checkerMemId(MemberVO mvo);
    int insert(MemberVO mvo);
}
