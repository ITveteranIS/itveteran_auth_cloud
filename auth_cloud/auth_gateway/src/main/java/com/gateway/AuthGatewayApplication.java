package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope  // 实现配置动态自动刷新
public class AuthGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthGatewayApplication.class, args);
    }

}
