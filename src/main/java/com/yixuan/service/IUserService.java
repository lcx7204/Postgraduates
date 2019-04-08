package com.yixuan.service;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author:linchengxin
 * @Date:2019/4/7 21:58
 */
public interface IUserService {
    ServerResponse<User> login(String nickName, String password);
}
