package com.blind.back.blind_back.member.act;

import com.blind.back.blind_back.member.biz.MemberService;
import com.blind.back.blind_back.member.vo.CustomUserPrincipalVO;
import com.blind.back.blind_back.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class MemberAction {
    private final MemberService mService;

    @GetMapping("/")
    public String loadExceptionPage(ModelMap model) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserPrincipalVO userPrincipalVO = (CustomUserPrincipalVO) auth.getPrincipal();
        model.addAttribute("name",userPrincipalVO.getUsername());
        model.addAttribute("auth",userPrincipalVO.getAuthorities());
        return "index";
    }


    @PostMapping(value="/join")
    public Map<String, Object> joinA(@RequestBody MemberVO mvo) {
        Map<String, Object> rtnMap = new HashMap<>();

        String rtnCode = mService.InsertUser(mvo);

        System.out.println(rtnCode);

        rtnMap.put("flag", true);
        rtnMap.put("data", mvo);
        return rtnMap;
    }

    @PostMapping(value="/getIp")
    public Map<String, Object> getIp(@RequestBody MemberVO mvo, HttpServletRequest req) {
        Map<String, Object> rtnMap = new HashMap<>();


        System.out.println(req.getRemoteAddr());

        rtnMap.put("flag", true);
        rtnMap.put("data", mvo);
        return rtnMap;
    }
}
