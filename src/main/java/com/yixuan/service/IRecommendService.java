package com.yixuan.service;

import com.github.pagehelper.PageInfo;
import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Recommend;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/10 6:52
 */
public interface IRecommendService {
    /**
     * 添加推荐
     * @param recommend
     * @return
     */
    ServerResponse addRecommend(Recommend recommend);

    /**
     * 分页获取推荐列表
     * @return
     */
    ServerResponse<PageInfo> getRecommendList(Integer pageNum, Integer pageSize);

    /**
     * 根据ID查询推荐详情
     * @param recommendId
     * @return
     */
    ServerResponse findRecommendById(String recommendId);

    /**
     * 修改推荐
     * @param recommend
     * @return
     */
    ServerResponse updateRecommend(Recommend recommend);

    /**
     * 删除推荐
     * @param recommendId
     * @return
     */
    ServerResponse deleteRecommend(String recommendId);

    /**
     * 根据分类获取推荐列表
     * @param recommendCategory
     * @return
     */
    ServerResponse<List<Recommend>> wxGetRecommentListByCategory(String recommendCategory);
}
