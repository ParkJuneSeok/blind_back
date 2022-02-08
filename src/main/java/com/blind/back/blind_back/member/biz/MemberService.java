package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mService;

    public int checkerMemId(MemberVO mvo ) {
        return mService.checkerMemId(mvo);
    }

    public int insert(MemberVO mvo ) {
        return mService.insert(mvo);
    }
}
