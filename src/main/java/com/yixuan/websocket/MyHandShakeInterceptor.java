package com.yixuan.websocket;

import com.yixuan.common.Const;
import com.yixuan.entity.User;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author:linchengxin
 * @Date:2019/4/22 18:49
 * 握手拦截器   拦截握手前，握手后的两个切面
 */
@Component
public class MyHandShakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        System.out.println("webSocket用户[ID："+((ServletServerHttpRequest)serverHttpRequest).getServletRequest().getSession(false).getAttribute(Const.CURRENT_USER)+"]已经建立连接");
        if (serverHttpRequest instanceof ServletServerHttpRequest){
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest)serverHttpRequest;
            HttpSession session = serverRequest.getServletRequest().getSession(false);
            User user = (User)session.getAttribute(Const.CURRENT_USER);
            if(user != null){
                map.put("uid",user.getUserId());
                System.out.println("用户ID："+user.getUserId());
            }else {
                System.out.println("user为空");
                return false;
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
