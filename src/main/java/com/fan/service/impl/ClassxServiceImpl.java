package com.fan.service.impl;

import com.fan.domain.Classx;
import com.fan.mapper.ClassxMapper;
import com.fan.service.ClassxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClassxServiceImpl implements ClassxService {
    @Resource
    private ClassxMapper classxMapper;
    @Override
    public Classx selectClassXByClassx(Classx classx) {
        return classxMapper.selectClassXByClassx(classx);
    }
}
