package com.zph.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zph.model.LoginModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<LoginModel> {

}
