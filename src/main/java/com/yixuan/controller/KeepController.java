package com.yixuan.controller;

import com.yixuan.common.Const;
import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Keep;
import com.yixuan.entity.User;
import com.yixuan.service.IKeepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author:linchengxin
 * @Date:2019/4/9 7:25
 */
@Controller
@RequestMapping(value = "/keep")
public class KeepController {

    @Autowired
    private IKeepService iKeepService;

    /**
     * 根据用户ID查询收藏列表
     * @param collectionUser
     * @return
     */
    @RequestMapping(value = "/selectByUserId")
    @ResponseBody
    public ServerResponse selectByUserId(String collectionUser){
        return iKeepService.getKeepListByUserId(collectionUser);
    }

    /**
     * 添加收藏
     * @param keep
     * @return
     */
    @RequestMapping(value = "/addKeep",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addKeep(@RequestBody Keep keep){
        return iKeepService.addKeep(keep.getCollectionInfo(),keep.getCollectionUser());
    }

    /**
     * 取消收藏
     * @param keep
     * @return
     */
    @RequestMapping(value = "/deleteKeep",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteKeep(@RequestBody Keep keep){
        return iKeepService.deleteKeep(keep.getCollectionInfo(),keep.getCollectionUser());
    }

    /**
     * 检测该用户是否收藏该文章
     * @param keep
     * @return
     */
    @RequestMapping(value = "/hasKeep")
    @ResponseBody
    public ServerResponse hasKeep(@RequestBody Keep keep){
        return iKeepService.hasKeep(keep.getCollectionInfo(),keep.getCollectionUser());
    }
}
