package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService{
    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String InsertUser(MemberVO userVO) {
        userVO.setMemPw(bCryptPasswordEncoder.encode(userVO.getMemPw()));
        int flag = memberMapper.registerMember(userVO);
        if (flag > 0) {
            int memNo = memberMapper.findMemId(userVO.getMemId());
            int roleNo = memberMapper.findRoleNo(userVO.getRoleName());
            userVO.setRoleNo(memNo);
            userVO.setMemNo(roleNo);
            memberMapper.registerRole(userVO);

            return "success";
        }
        return "fail";
    }
}
