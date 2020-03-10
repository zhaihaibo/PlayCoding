package com.example.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.demo.global.RtnResult;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/*
@author  zhaihaibo
@data 2020/3/9 - 21:13
*/
public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user!= null){
            return  true;
        }
        RtnResult fail = RtnResult.fail("请登录后再操作！");
        String s = JSON.toJSONString(fail);
        outputMsgByOutputStream(response, s);
        return false;
    }

    public void outputMsgByOutputStream(HttpServletResponse resp, String msg) throws IOException {
        OutputStream outputStream = resp.getOutputStream();// 获取OutputStream输出流
        resp.setHeader("content-type", "text/html;charset=UTF-8");// 通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        byte[] dataByteArr = msg.getBytes("UTF-8");// 将字符转换成字节数组，指定以UTF-8编码进行转换
        outputStream.write(dataByteArr);// 使用OutputStream流向客户端输出字节数组
    }

}
