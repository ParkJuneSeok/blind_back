package com.blind.back.blind_back.member.act;

import com.blind.back.blind_back.member.biz.MemberService;
import com.blind.back.blind_back.member.entity.Member;
import com.blind.back.blind_back.member.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberAction {

    private final MemberService mService;

    @GetMapping("/login")
    public String loginV() {
        return "/account/login";
    }

    @GetMapping("/register")
    public String registerV() {
        return "/account/register";
    }

    @PostMapping("/register")
    public String registerA(Member member) {
        mService.save(member);
        return "redirect:/";
    }

}
