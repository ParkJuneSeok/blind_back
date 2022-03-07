package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.entity.Member;
import com.blind.back.blind_back.member.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository mRepository;

    public Member save(Member m) {
        return mRepository.save(m);
    }

}
