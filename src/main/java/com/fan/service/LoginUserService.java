package com.fan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fan.domain.LoginUser;

public interface LoginUserService extends IService<LoginUser> {
    public LoginUser getLoginUserByNameAndPassword(String username, String password);
}
