package com.sinoteif.l2.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by admin on 2019/9/6.
 */

public class WebSocketHandShakeIntercepter implements HandshakeInterceptor{
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("【HttpHandShakeInterceptor-beforeHandshake方法】");
        ServletServerHttpRequest httpRequest = (ServletServerHttpRequest) request;
        HttpServletRequest servletRequest = httpRequest.getServletRequest();
        String sessionID = servletRequest.getSession().getId();
        System.out.println("【SessionId】------>"+sessionID);
        attributes.put("sessionID", sessionID);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("【HttpHandShakeInterceptor-afterHandshake方法】");
    }
}
