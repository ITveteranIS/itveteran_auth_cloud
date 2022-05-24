package com.boots.config.webStatusconfig;

import com.bases.restult.UrlReturn;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.admin.config.webStatusconfig"}
 * @ClassName: {"classname":"WebServerAutoConfigurations"}
 * @Description: TODO {"description":"404 203 等 。。。。"} 0_0
 * @Date : Create in {"date":"2022/5/1921:14"}
 */
@SuppressWarnings("all")
@Configuration
public class WebServerAutoConfigurations {
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory2(){
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, UrlReturn.ERROR_400);
        ErrorPage errorPage401 = new ErrorPage(HttpStatus.UNAUTHORIZED, UrlReturn.ERROR_401);
        ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN, UrlReturn.ERROR_403);
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, UrlReturn.ERROR_404);
        ErrorPage errorPage415 = new ErrorPage(HttpStatus.UNSUPPORTED_MEDIA_TYPE, UrlReturn.ERROR_415);
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, UrlReturn.ERROR_500);
        serverFactory.addErrorPages(errorPage400,errorPage401,errorPage403,errorPage404,errorPage415,errorPage500);
        return serverFactory;
    }
}
