package com.yixuan.service.impl;

import com.yixuan.common.ServerResponse;
import com.yixuan.dao.KeepMapper;
import com.yixuan.entity.Keep;
import com.yixuan.service.IKeepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author:linchengxin
 * @Date:2019/4/9 7:28
 */
@Service
public class KeepServiceImpl implements IKeepService {

    @Autowired
    private KeepMapper keepMapper;

    /**
     * 根据用户ID获取收藏列表
     * @param userId
     * @return
     */
    @Override
    public ServerResponse<List<Keep>> getKeepListByUserId(String userId) {
        if (userId == "" || userId == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        List<Keep> keepList = new ArrayList<>();
        keepList = keepMapper.selectByUserId(userId);
        return ServerResponse.createBySuccess(keepList);
    }

    /**
     * 添加收藏
     * @param collectionInfo
     * @param collectionUser
     * @return
     */
    @Override
    public ServerResponse addKeep(String collectionInfo, String collectionUser) {
        if (collectionInfo == "" || collectionInfo == null || collectionUser == "" || collectionUser == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        Keep keep = new Keep();
        String collectionId = UUID.randomUUID().toString().replace("-","");
        keep.setCollectionId(collectionId);
        keep.setCollectionInfo(collectionInfo);
        keep.setCollectionUser(collectionUser);
        keep.setCollectionDate(new Date());
        int resultCount = keepMapper.insert(keep);
        if (resultCount > 0){
            return ServerResponse.createBySuccessMessage("收藏成功");
        }
        return ServerResponse.createByErrorMessage("收藏失败");
    }

    /**
     * 取消收藏
     * @param collectionInfo
     * @param collectionUser
     * @return
     */
    @Override
    public ServerResponse deleteKeep(String collectionInfo, String collectionUser) {
        if (collectionInfo == "" || collectionInfo == null || collectionUser == "" || collectionUser == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = keepMapper.deleteKeep(collectionInfo,collectionUser);
        if (resultCount > 0){
            return ServerResponse.createBySuccess();
        }else {
            return ServerResponse.createByError();
        }
    }

    /**
     * 检测用户是否收藏该文章
     * @param collectionInfo
     * @param collectionUser
     * @return
     */
    @Override
    public ServerResponse hasKeep(String collectionInfo, String collectionUser) {
        Keep keep = keepMapper.hasKeep(collectionInfo,collectionUser);
        if (keep != null){
            return ServerResponse.createBySuccess(1);   //1表示已收藏
        }else {
            return ServerResponse.createBySuccess(0);   //0表示未收藏
        }
    }
}
