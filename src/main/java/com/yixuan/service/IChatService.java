package com.yixuan.service;

import com.yixuan.common.ServerResponse;
import com.yixuan.entity.Chat;
import net.sf.jsqlparser.schema.Server;

/**
 * @Author:linchengxin
 * @Date:2019/4/23 7:34
 */
public interface IChatService {
    /**
     * 添加聊天消息
     * @param chat
     * @return
     */
    ServerResponse addChatMsg(Chat chat);

    ServerResponse addChat(Chat chat);

    /**
     * 获取聊天记录
     * @param userId
     * @return
     */
    ServerResponse getUserChat(String userId);

    /**
     * 获取聊天用户列表
     * @return
     */
    ServerResponse getUserList();
}
