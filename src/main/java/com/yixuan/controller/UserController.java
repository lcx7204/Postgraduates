package com.yixuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yixuan.common.Const;
import com.yixuan.common.ServerResponse;
import com.yixuan.entity.User;
import com.yixuan.service.IUserService;
import com.yixuan.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    /**
     * 管理员登录
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ServerResponse<User> login(@RequestBody User user, HttpSession session){
        ServerResponse<User> res = iUserService.login(user.getNickName(),user.getPassword());
        if(res.isSuccess()){
            User newUser = res.getData();
            if(newUser.getUserType() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,newUser);
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return res;
    }

    /**
     * 微信授权登录
     * @param code
     * @return
     */
    @RequestMapping(value = "/wxLogin",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> wxLogin(String code){
        Map<String,String> map = new HashMap<>();
        String APPID = "wx515bc0896882b92e";
        String SECRET = "91effa4104c58f967018cc0c8cb4922a";
        String JSCODE = code;
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+JSCODE+"&grant_type=authorization_code";
        //发送请求
        String data = HttpUtil.get(url);
        JSONObject json = JSONObject.parseObject(data);
        String openId = String.valueOf(json.get("openid"));
        String session_key = String.valueOf(json.get("session_key"));
        map.put("openid",openId);
        map.put("session_key",session_key);
        return map;
    }

    /**
     * 生成本地用户数据
     * @param user
     * @return
     */
    @RequestMapping(value = "/wxRegister",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse wxRegister(@RequestBody User user,HttpSession session){
        String userId = UUID.randomUUID().toString().replace("-","");
        user.setUserId(userId);
        User currentUser = iUserService.wxGetUserByOpenId(user.getOpenId());
        if (currentUser == null){
            //该用户未保存到数据库，生成新数据
            return iUserService.wxRegister(user,session);
        }else {
            //该用户已存在
            session.setAttribute(Const.CURRENT_USER,currentUser);
            Map<String,String> map = new HashMap<>();
            map.put("userId",currentUser.getUserId());
            map.put("sessionId",session.getId());
            return ServerResponse.createBySuccess(map);
        }
    }
}
