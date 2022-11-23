package com.zph.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zph.Utils.R;
import com.zph.mapper.LoginMapper;
import com.zph.model.LoginModel;
import com.zph.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, LoginModel> implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public R<HashMap<String, String>> login(LoginModel loginModel) {

        //判断账号
        LambdaQueryWrapper<LoginModel> query = new LambdaQueryWrapper<>();
        query.eq(LoginModel::getUserName, loginModel.getUserName())
                .eq(LoginModel::getPassword, loginModel.getPassword());
        LoginModel one = getOne(query);
        if (one == null) {
            return R.error("账号错误");
        }

        //创建token
        String token = UUID.randomUUID().toString();

        //保存到redis,1分钟时效
        redisTemplate.opsForValue().set("login:token:" + loginModel.getUserName(), token, 1, TimeUnit.MINUTES);

        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        //返回
        return R.success(map);
    }
}
