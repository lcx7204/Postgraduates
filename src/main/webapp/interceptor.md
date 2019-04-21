描述：今天做项目的时候遇到一个小问题，记录一下方便以后查看;项目采用前后端分离，前端框架为vue.js+element ui,后端采用SSM框架。  
问题：  
1.后台登录成功后将用户信息存到session中；其他请求判断用户是否登录时从session中取不到值。  
在浏览器控制台的NETWORK中有个请求列表，里面的Response-Header中没有set-Cookie
```
    user是个用户对象
    session.setAttribute("current_user",user);
```
```
    执行保存逻辑时，判断用户是否登录：
    session.getAttribute("current_user");
    在这里取到的值为null.
```
经过查询，前后端分离时，存在跨域问题，所以要解决跨域，这里考虑用一个拦截器来实现
> 1.在spring-mvc.xml加入拦截器配置文件
```
<!-- 配置登录拦截器 -->
    <mvc:interceptors>
        <mvc:interceptor>
            <!-- 拦截所有mvc控制器 -->
            <mvc:mapping path="/**"/>
            <!-- 将登录请求排除在拦截之外 -->
            <mvc:exclude-mapping path="/user/login" />
            <!--拦截器所在的类-->
            <bean class="com.yixuan.util.AjaxFilter"></bean>
        </mvc:interceptor>
    </mvc:interceptors>
```
> 2.创建拦截器类:AjaxFilter.java
```
@Component
public class AjaxFilter implements HandlerInterceptor{
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
```
> 3.前端请求添加一个属性:xhrFields: {withCredentials: true}
```
在vue.js中,直接在main.js中直接配置即可

import http from 'axios';
http.defaults.withCredentials=true;
Vue.prototype.$axios = http;

然后其他页面通过$axios发送请求的时候默认带上了这个属性
```

#### 说明
interceptor return false时将不继续执行后续代码，return true时会继续执行后续代码。
response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
设置完成后，在浏览器控制台会出现set-cookie,所以下次请求时系统会自动携带该cookie到后台去判断。