package com.blind.back.blind_back.member.act;

import com.blind.back.blind_back.member.biz.MemberService;
import com.blind.back.blind_back.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberAction {
    private final MemberService mService;

    @PostMapping(value="/checker")
    public int checkerId(@RequestBody MemberVO mvo) {
        return mService.checkerMemId(mvo);
    }

    @PostMapping(value="/join")
    public Map<String, Object> joinA(@RequestBody MemberVO mvo) {
        Map<String, Object> rtnMap = new HashMap<>();

        int rtnCode = mService.insert(mvo);

        System.out.println(rtnCode);

        rtnMap.put("flag", true);
        rtnMap.put("data", mvo);
        return rtnMap;
    }
}
