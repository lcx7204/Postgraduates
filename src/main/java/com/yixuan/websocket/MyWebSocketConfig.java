package com.yixuan.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Author:linchengxin
 * @Date:2019/4/22 17:34
 * @Component 注解告诉springmvc该类是一个spring IOC容器下管理的类
 * 配置webSocket的处理器和握手拦截器
 */
@Component
@EnableWebSocket
public class MyWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Autowired
    private MyWebSocketHander hander;

    //添加websocket处理器，添加握手拦截器  拦截器先执行 然后到处理器
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(hander, "/ws").addInterceptors(new MyHandShakeInterceptor());
        webSocketHandlerRegistry.addHandler(hander, "/ws/sockjs").addInterceptors(new MyHandShakeInterceptor()).withSockJS();
    }
}
