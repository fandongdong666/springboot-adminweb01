package com.fan.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fan
 * @since 2021-05-07
 */
public interface IUserService extends IService<User> {

    IPage<User> selectByWrapper(Page<User> page, QueryWrapper<User> queryWrapper);
}
