package com.zph.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    /**
     * 注册
     * @return
     */
    @PostMapping("/signin")
    public String signin() {
        return "signin";
    }

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public String login() {
        return "login";
    }
}
