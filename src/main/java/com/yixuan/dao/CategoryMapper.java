package com.yixuan.dao;

import com.yixuan.entity.Category;
import com.yixuan.entity.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    int countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(String categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(String categoryId);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /**
     * 获取分类信息
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 小程序获取推荐模块分类信息
     * @param categoryType
     * @return
     */
    List<Category> wxGetRecommendCategory(String categoryType);
}