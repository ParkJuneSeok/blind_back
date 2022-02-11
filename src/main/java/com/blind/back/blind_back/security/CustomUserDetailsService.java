package com.blind.back.blind_back.security;

import com.blind.back.blind_back.member.biz.MemberMapper;
import com.blind.back.blind_back.member.vo.CustomUserPrincipalVO;
import com.blind.back.blind_back.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
        ArrayList<MemberVO> userList = memberMapper.findByMemId(memId);

        if(userList.size() == 0) {
            throw new UsernameNotFoundException("User " + memId + " Not Found!");
        }

        return new CustomUserPrincipalVO(userList); //UserDetails 클래스를 상속받은 UserPrincipalVO 리턴한다.
    }
}
