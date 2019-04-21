package com.yixuan.service.impl;

import com.yixuan.common.Const;
import com.yixuan.common.ServerResponse;
import com.yixuan.dao.UserMapper;
import com.yixuan.entity.User;
import com.yixuan.service.IUserService;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:linchengxin
 * @Date:2019/4/8 10:44
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 管理员登录
     * @param nickName
     * @param password
     * @return
     */
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

    /**
     * 生成本地用户数据
     * @param user
     * @return
     */
    public ServerResponse wxRegister(User user, HttpSession session){
        if (user == null){
            return ServerResponse.createByErrorMessage("参数不能为空");
        }
        int resultCount = userMapper.insert(user);
        if (resultCount > 0){
            session.setAttribute(Const.CURRENT_USER,user);
            Map<String,String> map = new HashMap<>();
            map.put("userId",user.getUserId());
            map.put("sessionId",session.getId());
            return ServerResponse.createBySuccess(user.getUserId());
        }
        return ServerResponse.createByErrorMessage("用户信息保存失败");
    }

    /**
     * 根据openid判断用户是否已经存在
     * @param openId
     * @return
     */
    @Override
    public User wxGetUserByOpenId(String openId) {
        User user = userMapper.wxGetUserByOpenId(openId);
        return user;
    }
}
