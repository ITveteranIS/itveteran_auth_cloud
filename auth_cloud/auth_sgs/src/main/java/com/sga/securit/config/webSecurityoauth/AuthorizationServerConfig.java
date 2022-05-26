package com.sga.securit.config.webSecurityoauth;

import cn.hutool.core.collection.CollectionUtil;
import com.sga.securit.datails.client.ClientDetailsServiceImpl;
import com.sga.securit.datails.user.SysUserDatails;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.securit.config.webSecurityoauth"}
 * @ClassName: {"classname":"AuthorizationServerConfig"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/254:16"}
 */
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;
    private final ClientDetailsServiceImpl clientDetailsService;

    /**
     * OAuth2客户端
     */
    @Override
    @SneakyThrows
    public void configure(ClientDetailsServiceConfigurer clients) {
        clients.withClientDetails(clientDetailsService);
    }

    /**
     * 配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // Token增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(tokenEnhancer());
        tokenEnhancers.add(jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        // 获取原有默认授权模式(授权码模式、密码模式、客户端模式、简化模式)的授权者
        List<TokenGranter> granterList = new ArrayList<>(Arrays.asList(endpoints.getTokenGranter()));

        CompositeTokenGranter compositeTokenGranter = new CompositeTokenGranter(granterList);
        endpoints
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain)
                .tokenGranter(compositeTokenGranter)
                .reuseRefreshTokens(true)
                .tokenServices(tokenServices(endpoints))
        ;
    }

    public DefaultTokenServices tokenServices(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(tokenEnhancer());
        tokenEnhancers.add(jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setTokenEnhancer(tokenEnhancerChain);
        return tokenServices;

    }

    /**
     * JWT内容增强
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            Map<String, Object> additionalInfo = CollectionUtil.newHashMap();
            Object principal = authentication.getUserAuthentication().getPrincipal();
            System.out.println(principal);
            if (principal instanceof SysUserDatails){
                SysUserDatails sysUserDetails = (SysUserDatails) principal;
                additionalInfo.put("userId", sysUserDetails.getUserId());
                additionalInfo.put("username", sysUserDetails.getUsername());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            }

            return accessToken;
        };
    }

    /**
     * 使用非对称加密算法对token签名
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair());
        return converter;
    }

    /**
     * 密钥库中获取密钥对(公钥+私钥)
     */
    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        KeyPair keyPair = factory.getKeyPair("jwt", "123456".toCharArray());
        return keyPair;
    }
}
