package com.web.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.util.redistool"}
 * @ClassName: {"classname":"CacheConstant"}
 * @Description: TODO {"description":"FeignConfig"} 0_0
 * @Date : Create in {"date":"2022/5/1922:47"}
 */
@Configuration
@SuppressWarnings("all")
public class FeignConfig {
    @Value("${spring.application.name}")
    private String applicationName;


     /**
        * <span>Description:</span><span style="color:yellow"> ♥{让DispatcherServlet 向子线程传递Requestontext}♥ </span>
        * @MethodName: dispatcherRegistration
        * @author it veteran Jie
        * @param  servlet
        * @returned  注册Bean
        * @Date:  | Create 2022/5/24 |
        *         -------------------
        */
    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet servlet){
        servlet.setThreadContextInheritable(true);
        return new ServletRegistrationBean<>(servlet,"/**");
    }

     /**
        * <span>Description:</span><span style="color:yellow"> ♥{<per>
         覆写拦截器 在feign发送请求前取出原来的header并转发
         在经过网关后 A服务在调用B服务的时候 将A服务的请求头转发给B服务
         </per>}♥ </span>
        * @MethodName: requestInterceptor
        * @author it veteran Jie
        * @returned  拦截器
        * @Date:  | Create 2022/5/24 |
        *         -------------------
        */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return (template)-> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //获取请求头
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    //将请求头保存到模板中
                    template.header(name, values);
                }
                System.out.println("当前服务名称:" + applicationName);
                template.header("serviceName", applicationName);
            }

        };
        }

}
