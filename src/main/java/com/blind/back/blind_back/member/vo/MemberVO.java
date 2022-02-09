package com.blind.back.blind_back.member.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MemberVO implements UserDetails {
    private int             memNo;          // 회원 고유 코드
    private String          memId;          // 회원 아이디
    private String          memPw;          // 회원 비번
    private List<String>    roles;          // 회원 고유 권한
    private String          memNick;        // 회원 닉네임
    private String          insDate;        // 가입일
    private String          updDate;        // 정보 수정일

    // 시크릿 정보 //
    private String grade;       // 어드민에서 가져오는 직책 정보
    private String department;  // 어드민에서 가져오는 부서 정보

    protected MemberVO() {}

    public MemberVO(String memId, String memPw, List<String> roles) {
        this.memId = memId;
        this.memPw = memPw;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return memPw;
    }

    @Override
    public String getUsername() {
        return memId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
