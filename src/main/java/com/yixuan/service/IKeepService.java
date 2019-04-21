package com.yixuan.service;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Keep;

import java.util.List;

/**
 * @Author:linchengxin
 * @Date:2019/4/9 7:27
 */
public interface IKeepService {

    /**
     * 根据用户ID获取收藏列表
     * @param userId
     * @return
     */
    ServerResponse<List<Keep>> getKeepListByUserId(String userId);

    /**
     * 添加收藏
     * @param collectionInfo
     * @param collectionUser
     * @return
     */
    ServerResponse addKeep(String collectionInfo,String collectionUser);

    /**
     * 取消收藏
     * @param collectionInfo
     * @param collectionUser
     * @return
     */
    ServerResponse deleteKeep(String collectionInfo,String collectionUser);

    /**
     * 检测用户是否收藏该文章
     * @param collectionInfo
     * @param collectionUser
     * @return
     */
    ServerResponse hasKeep(String collectionInfo,String collectionUser);
}
