package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.entity.Member;
import com.blind.back.blind_back.member.entity.Role;
import com.blind.back.blind_back.member.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository mRepository;
    private final PasswordEncoder passwordEncoder;

    public Member save(Member m) {
        m.setMemPw(passwordEncoder.encode(m.getMemPw()));
        m.setEnabled(true);

        Role role = new Role();
            role.setRoleNo(2l);

        m.getRoles().add(role);
        return mRepository.save(m);
    }

}



