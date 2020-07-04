package com.zzm.applications.mvc.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * <b>Description</b>  CustomizedListener  用于注册Listener ，因为springbooot使用嵌入式Servlet容器，没有可配置的web.xml
 *
 * @Author Zhenzhen
 * @Since 2020-06-25 周四 11:14
 * @Info CustomizedListener
 */


public class CustomizedListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomizedListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("contextInitialized web starting.......启动！");
}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("contextDestroyed web destroyed.......销毁！");
    }
}
