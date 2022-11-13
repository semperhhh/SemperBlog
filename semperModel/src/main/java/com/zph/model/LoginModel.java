package com.zph.model;
import javax.validation.constraints.NotBlank;


public class LoginModel {

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码
     */
    private String code;
}
