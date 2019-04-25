package com.paper.question.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决跨域 - 默认开启
 * 属性配置参考：custom.filters.cross-origin.enable=true
 */
@Order(1)
@Component
@WebFilter(urlPatterns = {"/*"})
@ConditionalOnProperty(name = "custom.filters.cross-origin.enable", havingValue = "true", matchIfMissing = true)
public class CrossOriginFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrossOriginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("启动跨域访问过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        resp.addHeader("Access-Control-Allow-Headers", "Token,Content-Type,Authorization,Content-Disposition,Accept,ServerTime,x_requested_with");
        resp.addHeader("Access-Control-Expose-Headers", "Token,Content-Type,Authorization,Content-Disposition,Accept,ServerTime");

        // 添加服务器当前时间的响应头设置
        resp.addHeader("ServerTime", Integer.toString(DateTimeUtil.nowSecond2()));

        HttpServletRequest req = (HttpServletRequest) request;
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            resp.setStatus(200);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
