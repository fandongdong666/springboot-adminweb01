package com.fan.mapper;

import com.fan.domain.Classx;
import com.fan.domain.ClassxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassxMapper {
    Classx selectClassXByClassx(Classx classx);

    long countByExample(ClassxExample example);

    int deleteByExample(ClassxExample example);

    int deleteByPrimaryKey(Integer classxId);

    int insert(Classx record);

    int insertSelective(Classx record);

    List<Classx> selectByExample(ClassxExample example);

    Classx selectByPrimaryKey(Integer classxId);

    int updateByExampleSelective(@Param("record") Classx record, @Param("example") ClassxExample example);

    int updateByExample(@Param("record") Classx record, @Param("example") ClassxExample example);

    int updateByPrimaryKeySelective(Classx record);

    int updateByPrimaryKey(Classx record);
}