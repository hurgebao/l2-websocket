package com.sinoteif.l2.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

/**
 * Created by admin on 2019/9/5.
 */
public class MySpringConfigurator extends ServerEndpointConfig.Configurator implements ApplicationContextAware {

    private static volatile ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MySpringConfigurator.context=applicationContext;
    }

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
        return context.getBean(clazz);
    }
}
