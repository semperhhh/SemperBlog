package com.zph.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zph.Utils.R;
import com.zph.model.LoginModel;

import java.util.HashMap;

public interface LoginService extends IService<LoginModel> {

    /**
     * 登录
     * @param loginModel
     */
    public R<HashMap<String, String>> login(LoginModel loginModel);
}
