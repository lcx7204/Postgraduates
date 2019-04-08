package com.yixuan.service.impl;

import com.yixuan.common.ServerResponse;
import com.yixuan.dao.UserMapper;
import com.yixuan.entity.User;
import com.yixuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:linchengxin
 * @Date:2019/4/8 10:44
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String nickName, String password) {
        int resultCount = userMapper.checkNickName(nickName);
        if(resultCount == 0 ){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        User user  = userMapper.login(nickName,password);
        if(user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登录成功",user);
    }
}
