package com.sga.controller;
import com.api.dto.Oauth2TokenDto;
import com.bases.restult.ResultResponse;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;
/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.controller"}
 * @ClassName: {"classname":"AuthController"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/252:34"}
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/oauth")
@Api(description = "管理", tags = "AuthController")
@Slf4j
public class AuthController {

    private final KeyPair  keyPair;

    private final TokenEndpoint tokenEndpoint;


    @ApiOperation("获取Token")
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public Object postAccessTokens(Principal principal,@RequestParam Map<String,String> parameters)throws HttpRequestMethodNotSupportedException{
        System.out.println("-=-=-0-0-0-0-0-0--=-=1");
        OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(accessToken.getValue())
                .refreshToken(accessToken.getRefreshToken().getValue())
                .expiresIn(accessToken.getExpiresIn())
                .tokenHead("Bearer ").build();
        System.out.println(accessToken+"-=-=-=token");
        return ResultResponse.SUCCESS(oauth2TokenDto);
    }
    @ApiOperation("公开key")
    @GetMapping("/public-key")
    public Map<String, Object> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

}
