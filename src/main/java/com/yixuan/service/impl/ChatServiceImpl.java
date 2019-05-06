package com.yixuan.service.impl;

import com.yixuan.common.ServerResponse;
import com.yixuan.dao.ChatMapper;
import com.yixuan.dao.UserMapper;
import com.yixuan.entity.Chat;
import com.yixuan.entity.User;
import com.yixuan.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author:linchengxin
 * @Date:2019/4/23 7:34
 */
@Service
public class ChatServiceImpl implements IChatService {

    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 添加聊天消息
     * @param chat
     * @return
     */
    @Override
    public ServerResponse addChatMsg(Chat chat) {
        if(chat == null){
            return ServerResponse.createByErrorMessage("参数信息不能为空");
        }
        int resultCount = chatMapper.insert(chat);
        if(resultCount>0){
            return ServerResponse.createBySuccess("发送成功");
        }else {
            return ServerResponse.createByErrorMessage("发送失败");
        }
    }

    @Override
    public ServerResponse addChat(Chat chat) {
        if(chat == null){
            return ServerResponse.createByErrorMessage("参数信息不能为空");
        }
        chat.setChatDate(new Date());
        int resultCount = chatMapper.insert(chat);
        if(resultCount>0){
            return ServerResponse.createBySuccess("发送成功");
        }else {
            return ServerResponse.createByErrorMessage("发送失败");
        }
    }

    /**
     * 获取聊天记录
     * @param userId
     * @return
     */
    @Override
    public ServerResponse getUserChat(String userId) {
        if (userId == null){
            return ServerResponse.createByErrorMessage("参数信息不能为空");
        }
        List<Chat> chatList = chatMapper.getUserChat(userId);
        return ServerResponse.createBySuccess(chatList);
    }

    /**
     * 获取聊天用户列表
     * @return
     */
    @Override
    public ServerResponse getUserList() {
        List<User> chatList = userMapper.getUserList();
        return ServerResponse.createBySuccess(chatList);
    }
}
