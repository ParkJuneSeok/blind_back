package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

@Mapper
public interface MemberMapper {
    ArrayList<MemberVO> findByMemId(@Param("memId") String memId);
    int registerMember(MemberVO mvo);
    int registerRole(MemberVO mvo);
    int findMemId(String memId);
    int findRoleNo(String roleName);
}
