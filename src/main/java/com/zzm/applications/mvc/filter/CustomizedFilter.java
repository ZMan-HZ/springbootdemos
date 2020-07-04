package com.zzm.applications.mvc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * <b>Description</b>  CustomizedFilter 用于注册Filter，因为springbooot使用嵌入式Servlet容器，没有可配置的web.xml
 *
 * @Author Zhenzhen
 * @Since 2020-06-25 周四 10:59
 * @Info CustomizedFilter
 */

public class CustomizedFilter  implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CustomizedFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Customized Filter process...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
