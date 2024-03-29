package com.sinoteif.l2.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

/**
 * Created by admin on 2019/9/5.
 */
@Configuration
@ConditionalOnWebApplication
public class WebSocketAutoFindConfig {
    @Bean
    public ServerEndpointExporter getServerEndpointExporter(){
        return new ServerEndpointExporter();
    }
    @Bean
    public MySpringConfigurator getSpringConfigurator(){
        return new MySpringConfigurator();
    }
}
