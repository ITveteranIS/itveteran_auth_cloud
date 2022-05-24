package com.plus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.admin.config"}
 * @ClassName: {"classname":"MybatisPlusConfig"}
 * @Description: TODO {"description":"mybatisplus"} 0_0
 * @Date : Create in {"date":"2022/4/2318:07"}
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    /**
     * <span>@Description:</span><span style="color:yellow"> >>{mybatis plus 分页插件}<< </span>
     * @author it veteran Jie
     * @returned  MybatisPlusInterceptor
     * @Date: Create 16:35 2021/9/28
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
    @SuppressWarnings("deprecation")
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}
