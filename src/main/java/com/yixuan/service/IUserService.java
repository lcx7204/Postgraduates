package com.yixuan.service;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Author:linchengxin
 * @Date:2019/4/7 21:58
 */
public interface IUserService {
    /**
     * 管理员登录
     * @param nickName
     * @param password
     * @return
     */
    ServerResponse<User> login(String nickName, String password);

    /**
     * 生成本地用户数据
     * @param user
     * @return
     */
    ServerResponse wxRegister(User user, HttpSession session);

    /**
     * 根据openid判断用户是否已经存在
     * @param openId
     * @return
     */
    User wxGetUserByOpenId(String openId);
}
