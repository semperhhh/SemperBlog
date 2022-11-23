package com.zph.controller;

import com.zph.Utils.R;
import com.zph.model.LoginModel;
import com.zph.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

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
    public R<HashMap<String, String>> login(@RequestBody @Valid LoginModel loginModel) {
        log.info("login --- {} -- {}", loginModel.getUserName(), loginModel.getPassword());

        try {
            R<HashMap<String, String>> login = loginService.login(loginModel);
            return login;
        } catch (Exception e) {
            return R.error("error");
        }
    }
}
