package com.sinoteif.l2.endpoint;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sinoteif.l2.config.MySpringConfigurator;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2019/9/5.
 */
@Component
@ServerEndpoint(value="/myWebServer/{openId}",configurator = MySpringConfigurator.class)
public class WebServerEndPoint {
    private Session session;
    private static int onlineCount;
    private static Map<String,WebServerEndPoint> serverEndPointMap =new HashMap<>();
    @OnOpen
    public void onOpen(@PathParam(value="openId")String openId,@PathParam(value="role")String role,Session session){
        if(serverEndPointMap.containsKey(openId)){
            WebServerEndPoint webServerEndPoint=  serverEndPointMap.get(openId);
            this.session=webServerEndPoint.session;
            return;
        }
        serverEndPointMap.put(openId,this);
        this.session=session;
        this.addOnlineCount();
    }
    @OnClose
    public void onClose(Session session){
        serverEndPointMap.remove(this);
        this.subOnlineCount();
    }
    @OnError
    public void onError(Throwable throwable,Session session){
        System.out.println("error happening");
        throwable.printStackTrace();
    }
    @OnMessage
    public void onMessage(String msg){
        System.out.println("sendMessage:"+msg);
        sendMsg(msg);
    }
    private void sendMsg(String msg) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized  int getOnlineCount(){
        return onlineCount;
    }
    public static synchronized  void addOnlineCount(){
        onlineCount++;
    }
    public static synchronized  void subOnlineCount(){
        onlineCount--;
    }
}
