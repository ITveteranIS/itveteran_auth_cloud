package com.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.api.dto"}
 * @ClassName: {"classname":"Oauth2TokenDto"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/270:08"}
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Oauth2TokenDto {
    /**
     * 访问令牌
     */
    private String token;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 访问令牌头前缀
     */
    private String tokenHead;
    /**
     * 有效时间（秒）
     */
    private int expiresIn;
}
