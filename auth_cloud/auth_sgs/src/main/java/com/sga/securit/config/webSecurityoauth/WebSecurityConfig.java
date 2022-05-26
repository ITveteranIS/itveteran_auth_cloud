package com.sga.securit.config.webSecurityoauth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.securit.config.webSecurityoauth"}
 * @ClassName: {"classname":"WebSecurityConfig"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/254:15"}
 */
@Configuration
@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
@SuppressWarnings("all")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService sysUserDetailsService;
    private final String realName = "";
     /**
        * <span>Description:</span><span style="color:yellow"> ♥{拦截}♥ </span>
        * @MethodName: configure
        * @author it veteran Jie
        * @param  http
        * @returned  void
        * @Date:  | Create 2022/5/25 |
        *         -------------------
        */
     private static final String[] AUTH_LIST = {
             "/oauth/token",
             "/v2/api-docs",
             "/configuration/ui",
             "/swagger-resources/**",
             "/configuration/security",
             "/doc.html",
             "/webjars/**"};
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/oauth/**").permitAll().antMatchers(AUTH_LIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                //.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                ;
    }
     /**
        * <span>Description:</span><span style="color:yellow"> ♥{认证管理对象}♥ </span>
        * @MethodName: authenticationManagerBean
        * @author it veteran Jie
        * @returned   AuthenticationManager
        * @Date:  | Create 2022/5/25 |
        *         -------------------
        */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

     /**
        * <span>Description:</span><span style="color:yellow"> ♥{添加自定义认证器}♥ </span>
        * @MethodName: configure
        * @author it veteran Jie
        * @param  auth
        * @returned  void
        * @Date:  | Create 2022/5/25 |
        *         -------------------
        */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

     /**
        * <span>Description:</span><span style="color:yellow"> ♥{设置默认的用户名密码认证授权提供者}♥ </span>
        * @MethodName: daoAuthenticationProvider
        * @author it veteran Jie
        * @returned  DaoAuthenticationProvider
        * @Date:  | Create 2022/5/25 |
        *         -------------------
        */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(sysUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setHideUserNotFoundExceptions(false); // 是否隐藏用户不存在异常，默认:true-隐藏；false-抛出异常；
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
