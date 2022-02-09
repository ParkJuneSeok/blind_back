package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public Optional<MemberVO> findByMemId(String memId) {
        return memberMapper.findByMemId(memId);
    }

    public int checkerMemId(MemberVO mvo ) {
        return memberMapper.checkerMemId(mvo);
    }

    public int insert(MemberVO mvo ) {
        return memberMapper.insert(mvo);
    }

    public MemberVO searchMember(MemberVO mvo ) {
        return memberMapper.searchMember(mvo);
    }
}
