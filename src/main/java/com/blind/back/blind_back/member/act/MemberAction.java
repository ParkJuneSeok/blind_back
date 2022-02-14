package com.blind.back.blind_back.member.act;

import com.blind.back.blind_back.member.vo.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MemberAction {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, Model m) {
        m.addAttribute("name", name);
        return "greeting";
    }
}
