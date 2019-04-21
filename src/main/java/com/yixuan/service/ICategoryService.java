package com.yixuan.service;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Category;

import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/9 7:33
 */
public interface ICategoryService {
    /**
     * 获取分类信息
     * @return
     */
    ServerResponse<List<Category>> getCategoryList();

    /**
     * 小程序获取推荐模块分类信息
     * @param categoryType
     * @return
     */
    ServerResponse<List<Category>> wxGetRecommendCategory(String categoryType);
}
