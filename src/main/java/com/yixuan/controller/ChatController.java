package com.yixuan.controller;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Chat;
import com.yixuan.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:linchengxin
 * @Date:2019/4/24 8:01
 */
@Controller
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private IChatService iChatService;

    /**
     * 获取聊天记录
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserChat",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getUserChat(String userId){
        return iChatService.getUserChat(userId);
    }

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getUserList(){
        return iChatService.getUserList();
    }

    /**
     * 添加聊天消息
     * @param chat
     * @return
     */
    @RequestMapping(value = "addChat",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addChat(@RequestBody Chat chat){
        return iChatService.addChat(chat);
    }
}
