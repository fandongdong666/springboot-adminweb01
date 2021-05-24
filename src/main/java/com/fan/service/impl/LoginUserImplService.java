package com.fan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fan.domain.LoginUser;
import com.fan.entity.GoodsUser;
import com.fan.mapper.GoodsUserMapper;
import com.fan.mapper.LoginUserMapper;
import com.fan.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginUserImplService extends ServiceImpl<LoginUserMapper, LoginUser> implements LoginUserService {
    @Resource
    LoginUserMapper loginUserMapper;
    @Override
    public LoginUser getLoginUserByNameAndPassword(String username, String password) {
        LoginUser loginUser = loginUserMapper.getLoginUserByNameAndPassword(username, password);
        return loginUser;
    }
}
