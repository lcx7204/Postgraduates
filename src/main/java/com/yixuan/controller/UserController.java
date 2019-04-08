package com.yixuan.controller;

import com.yixuan.common.Const;
import com.yixuan.common.ServerResponse;
import com.yixuan.entity.User;
import com.yixuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author:linchengxin
 * @Date:2019/4/8 10:34
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/index")
    public void index(){
        System.out.println("index");
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ServerResponse<User> login(String nickName, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(nickName,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getUserType() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }
}
