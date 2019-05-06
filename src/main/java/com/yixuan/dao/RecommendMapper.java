package com.yixuan.dao;

import com.yixuan.entity.Recommend;
import com.yixuan.entity.RecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {
    int countByExample(RecommendExample example);

    int deleteByExample(RecommendExample example);

    int deleteByPrimaryKey(String recommendId);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendExample example);

    Recommend selectByPrimaryKey(String recommendId);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);

    /**
     * 小程序获取推荐列表
     * @return
     */
    List<Recommend> getRecommendList();

    /**
     * 管理员分页获取推荐信息
     * @return
     */
    List<Recommend> getRecommendListByAdmin();

    /**
     * 根据分类获取推荐列表
     * @param recommendCategory
     * @return
     */
    List<Recommend> wxGetRecommentListByCategory(String recommendCategory);
}