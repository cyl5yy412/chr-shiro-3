package com.chryl.mapper;

import com.chryl.po.GmRoleFun;
import com.chryl.po.GmRoleFunExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GmRoleFunMapper {
    long countByExample(GmRoleFunExample example);

    int deleteByExample(GmRoleFunExample example);

    int insert(GmRoleFun record);

    int insertSelective(GmRoleFun record);

    List<GmRoleFun> selectByExample(GmRoleFunExample example);

    int updateByExampleSelective(@Param("record") GmRoleFun record, @Param("example") GmRoleFunExample example);

    int updateByExample(@Param("record") GmRoleFun record, @Param("example") GmRoleFunExample example);
}