package com.api.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.api.dto"}
 * @ClassName: {"classname":"OAuth2ClientDTO"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2519:42"}
 */
@Data
@SuppressWarnings("all")
public class OAuth2ClientDTO implements Serializable {
    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 客户端密钥
     */
    private String clientSecret;

    /**
     * 资源id列表
     */
    private String resourceIds;

    /**
     * 授权范围
     */
    private String scope;

    /**
     * 授权方式
     */
    private String authorizedGrantTypes;

    /**
     * 回调地址
     */
    private String webServerRedirectUri;

    /**
     * 权限列表
     */
    private String authorities;

    /**
     * 认证令牌时效
     */
    private Integer accessTokenValidity;

    /**
     * 刷新令牌时效
     */
    private Integer refreshTokenValidity;

    /**
     * 扩展信息
     */
    private String additionalInformation;

    /**
     * 是否自动放行
     */
    private String autoapprove;
}
