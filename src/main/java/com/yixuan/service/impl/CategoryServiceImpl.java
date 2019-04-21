package com.yixuan.service.impl;

import com.yixuan.common.ServerResponse;
import com.yixuan.dao.CategoryMapper;
import com.yixuan.entity.Category;
import com.yixuan.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/9 7:34
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 获取分类信息
     * @return
     */
    @Override
    public ServerResponse<List<Category>> getCategoryList() {
        List<Category> categoryList = categoryMapper.getCategoryList();
        return ServerResponse.createBySuccess(categoryList);
    }

    /**
     * 小程序获取推荐模块分类信息
     * @param categoryType
     * @return
     */
    @Override
    public ServerResponse<List<Category>> wxGetRecommendCategory(String categoryType) {
        String categoryNewType = categoryType+"%";
        List<Category> categoryList = categoryMapper.wxGetRecommendCategory(categoryNewType);
        return ServerResponse.createBySuccess(categoryList);
    }
}
