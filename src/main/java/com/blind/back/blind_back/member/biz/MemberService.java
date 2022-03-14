package com.blind.back.blind_back.member.biz;

import com.blind.back.blind_back.member.entity.Member;
import com.blind.back.blind_back.member.entity.Role;
import com.blind.back.blind_back.member.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    public MemberRepository mRepository;
    @Autowired
    public PasswordEncoder passwordEncoder;

    public Member save(Member m) {
        m.setPassword(passwordEncoder.encode(m.getPassword()));
        m.setEnabled(true);

        Role role = new Role();
            role.setRoleNo(2l);

        m.getRoles().add(role);
        return mRepository.save(m);
    }

}



