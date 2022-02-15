package com.blind.back.blind_back.common.act;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonAction {
    @GetMapping
    public String index() {
        return "index";
    }
}
