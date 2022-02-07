package com.blind.back.blind_back.member.vo;

import lombok.Data;

@Data
public class MemberVO {
    private int     memNo;          // 회원 고유 코드
    private String  memId;          // 회원 아이디
    private String  memPw;          // 회원 비번
    private String  memNick;        // 회원 닉네임
    private String  insDate;        // 가입일
    private String  updDate;        // 정보 수정일

    // 시크릿 정보 //
    private String grade;       // 어드민에서 가져오는 직책 정보
    private String department;  // 어드민에서 가져오는 부서 정보
}
