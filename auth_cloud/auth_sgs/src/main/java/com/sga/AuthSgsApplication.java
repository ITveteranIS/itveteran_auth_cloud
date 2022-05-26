package com.sga;

import com.api.api.OAuthClientFeignClient;
import com.api.api.UserFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackageClasses = {UserFeignClient.class, OAuthClientFeignClient.class})
public class AuthSgsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthSgsApplication.class, args);
    }

}
