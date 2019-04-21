package com.yixuan.util;

import com.alibaba.fastjson.JSON;
import com.yixuan.common.Const;
import com.yixuan.common.ServerResponse;
import com.yixuan.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @Author:linchengxin
 * @Date:2019/4/17 21:36
 */
@Component
public class AjaxFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {
        String origin = httpServletRequest.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Accept, Content-Type");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.addHeader("Access-Control-AllX-Requested-Withow-Headers", "Content-Type, Authorization");
        response.addHeader("Access-Control-Max-Age", "3600");

        HttpSession session =httpServletRequest.getSession();
        System.out.println("拦截器中的session的id是====" + session.getId());
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if (currentUser==null){
            printJson(origin,response,"");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private static void printJson(String origin,HttpServletResponse response, String code) {
        ServerResponse serverResponse = new ServerResponse(1,"用户未登录");
        String content = JSON.toJSONString(serverResponse);
        printContent(origin,response, content);
    }

    private static void printContent(String origin,HttpServletResponse response, String content) {
        try {
            response.reset();
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Accept, Content-Type");
            response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
            response.addHeader("Access-Control-Max-Age", "3600");
            PrintWriter pw = response.getWriter();
            System.out.println(content);
            pw.write(content);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}