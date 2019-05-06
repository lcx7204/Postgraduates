package com.yixuan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yixuan.common.ServerResponse;
import com.yixuan.dao.RecommendMapper;
import com.yixuan.entity.Recommend;
import com.yixuan.service.IRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/10 6:53
 */
@Service
public class RecommendServiceImpl implements IRecommendService {

    @Autowired
    private RecommendMapper recommendMapper;
    @Value("${recommend.url}")
    private String recommendUrl;

    /**
     * 添加推荐
     * @param recommend
     * @return
     */
    @Override
    public ServerResponse addRecommend(Recommend recommend) {
        if(recommend == null){
            return ServerResponse.createByErrorMessage("参数信息不能为空");
        }
        int resultCount = recommendMapper.insert(recommend);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("添加成功!");
        }else {
            return ServerResponse.createByErrorMessage("添加失败");
        }
    }

    /**findRecommendById
     * 分页获取推荐列表
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getRecommendList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Recommend> recommendList = recommendMapper.getRecommendListByAdmin();
        for(Recommend recommend:recommendList){
            recommend.setRecommendIcon(recommendUrl+recommend.getRecommendIcon());
        }
        PageInfo pageResult = new PageInfo(recommendList);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 根据ID查找推荐详情
     * @param recommendId
     * @return
     */
    @Override
    public ServerResponse findRecommendById(String recommendId) {
        if (recommendId == null){
            return ServerResponse.createByErrorMessage("参数ID不能位空");
        }
        Recommend recommend = new Recommend();
        recommend = recommendMapper.selectByPrimaryKey(recommendId);
        recommend.setRecommendIcon(recommendUrl+recommend.getRecommendIcon());
        return ServerResponse.createBySuccess(recommend);
    }

    /**
     * 修改推荐
     * @param recommend
     * @return
     */
    @Override
    public ServerResponse updateRecommend(Recommend recommend) {
        if (recommend == null){
            return ServerResponse.createByErrorMessage("参数信息不能为空");
        }
        int resultCount = recommendMapper.updateByPrimaryKey(recommend);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("更新成功");
        }else {
            return ServerResponse.createByErrorMessage("更新失败");
        }
    }

    /**
     * 删除推荐
     * @param recommendId
     * @return
     */
    @Override
    public ServerResponse deleteRecommend(String recommendId) {
        if (recommendId == null){
            return ServerResponse.createByErrorMessage("参数ID不能位空");
        }
        int resultCount = recommendMapper.deleteByPrimaryKey(recommendId);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    /**
     * 根据分类获取推荐列表
     * @param recommendCategory
     * @return
     */
    @Override
    public ServerResponse<List<Recommend>> wxGetRecommentListByCategory(String recommendCategory) {
        if ("".equals(recommendCategory)){
            return ServerResponse.createByErrorMessage("参数信息不能为空");
        }
        List<Recommend> recommendList = recommendMapper.wxGetRecommentListByCategory(recommendCategory);
        return ServerResponse.createBySuccess(recommendList);
    }
}
