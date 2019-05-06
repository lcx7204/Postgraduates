package com.yixuan.websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yixuan.entity.Chat;
import com.yixuan.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author:linchengxin
 * @Date:2019/4/22 18:51
 * webSocket处理器
 */
@Component
public class MyWebSocketHander implements WebSocketHandler{

    @Autowired
    private IChatService iChatService;

    public static final Map<String,WebSocketSession> userSocketSessiobMap;

    static {
        userSocketSessiobMap = new HashMap<String,WebSocketSession>();
    }

    /**
     * 握手实现连接后
     * @param webSocketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        String uid = (String)webSocketSession.getAttributes().get("uid");
        if(userSocketSessiobMap.get(uid) == null){
            userSocketSessiobMap.put(uid,webSocketSession);
        }
    }

    /**
     * 发送信息前的处理
     * @param webSocketSession
     * @param webSocketMessage
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        //得到Socket通道中的数据并转化成Message对象
        Chat chat = new Gson().fromJson(webSocketMessage.getPayload().toString(),Chat.class);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        chat.setChatDate(now);
        chat.setSendId(chat.getSendId());
        chat.setAccessId(chat.getAccessId());
        chat.setChatContent(chat.getChatContent());
        //将信息保存到数据库
        iChatService.addChatMsg(chat);
        //发送Socket信息
        sendMessageToUser(chat.getAccessId(),new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm::ss").create().toJson(chat)));
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    /**
     * 在此刷新页面就相当于断开webSocket连接，原本userSocketSessionMao中的webSoketSession会被close.
     * 但是第二次创建新的wenSocketSession(open状态)又不会加入到userSocketSessionMap中，这样就无法发送消息
     * 所以应当在关闭连接时在这个切面增加去除userSocketSessionMap中当前处于close的webSocketSession
     * 让创建的webSocker=tSession(open状态)可疑加入到userSocketSesionMap中
     * @param webSocketSession
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("WebSocket:"+webSocketSession.getAttributes().get("uid"+"close connection"));
        Iterator<Map.Entry<String,WebSocketSession>> iterator = userSocketSessiobMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,WebSocketSession> entry = iterator.next();
            if (entry.getValue().getAttributes().get("uid")==webSocketSession.getAttributes().get("uid")){
                userSocketSessiobMap.remove(webSocketSession.getAttributes().get("uid"));
                System.out.println("webSocket in staticMap:"+webSocketSession.getAttributes().get("uid")+"removed");
            }
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 发送Socket消息
     * @param uid
     * @param msg
     */
    public void sendMessageToUser(String uid, TextMessage msg) throws IOException {
        WebSocketSession socketSession = userSocketSessiobMap.get(uid);
        if (socketSession != null && socketSession.isOpen()){
            socketSession.sendMessage(msg);
        }
    }
}
