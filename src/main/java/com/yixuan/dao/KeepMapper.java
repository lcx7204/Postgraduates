package com.yixuan.dao;

import com.yixuan.entity.Keep;
import com.yixuan.entity.KeepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeepMapper {
    int countByExample(KeepExample example);

    int deleteByExample(KeepExample example);

    int deleteByPrimaryKey(String collectionId);

    int insert(Keep record);

    int insertSelective(Keep record);

    List<Keep> selectByExample(KeepExample example);

    Keep selectByPrimaryKey(String collectionId);

    int updateByExampleSelective(@Param("record") Keep record, @Param("example") KeepExample example);

    int updateByExample(@Param("record") Keep record, @Param("example") KeepExample example);

    int updateByPrimaryKeySelective(Keep record);

    int updateByPrimaryKey(Keep record);
}