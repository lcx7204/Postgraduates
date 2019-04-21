package com.yixuan.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @Author:linchengxin
 * @Date:2019/4/20 22:28
 */
public class HttpUtil {
    public static String get(String url){
        String res = "";
        BufferedReader buff = null;
        try {
            URL realUrl = new URL(url);
            //打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            //设置请求头信息
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //建立实际连接
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            //遍历所有响应头字段
            for (String key:map.keySet()){
                System.out.println(key+"----->"+map.get(key));
            }
            buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = buff.readLine())!=null){
                res += line;
            }
        }catch (IOException e){
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }finally {
            try {
                if (buff != null) {
                    buff.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }
}
