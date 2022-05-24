package com.boots.config.swaggerconfig;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.swagger.config"}
 * @ClassName: {"classname":"SwaggerBootstrapConfig"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2423:40"}
 */
@Configuration
@EnableSwagger2
@SuppressWarnings("all")
@EnableSwaggerBootstrapUI
@EnableKnife4j
public class SwaggerBootstrapConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boots.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("micro-knife4j-user")
                .description("用户服务API文档")
                .contact(new Contact("it_veteran_jie ", "https://www.baidu.com","itveteran.jie@gmail.com"))
                .version("1.0")
                .build();
    }

//    @Bean
//    public Docket createRestApis(){
//        return  new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.boots.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("food API")
//                .description("cloud api接口文档！！")
//                .termsOfServiceUrl("开发中[请稍后]")
//                .contact(new Contact("it_veteran_jie ", "https://www.baidu.com","itveteran.jie@gmail.com"))
//                .version("1.0V")
//                .build();
//    }
}
