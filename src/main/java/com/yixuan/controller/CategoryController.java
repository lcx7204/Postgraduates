package com.yixuan.controller;

import com.yixuan.common.ServerResponse;
import com.yixuan.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:linchengxin
 * @Date:2019/4/9 7:51
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    /**
     * 获取分类列表
     * @return
     */
    @RequestMapping(value = "/getCategoryList")
    @ResponseBody
    public ServerResponse getCategoryList(){
        return iCategoryService.getCategoryList();
    }

    /**
     * 小程序获取推荐模块分类信息
     * @param categoryType
     * @return
     */
    @RequestMapping(value = "/wxGetRecommendCategory",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse wxGetRecommendCategory(String categoryType){
        return iCategoryService.wxGetRecommendCategory(categoryType);
    }
}
