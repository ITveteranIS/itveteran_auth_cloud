package com.api.api;

import com.api.dto.OAuth2ClientDTO;
import com.bases.restult.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.api.api"}
 * @ClassName: {"classname":"OAuthClientFeignClient"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2519:41"}
 */
@SuppressWarnings("all")
@FeignClient(value = "admin-boot",contextId = "oauth-client")
public interface OAuthClientFeignClient {

      /**
         * <span>Description:</span><span style="color:yellow"> ♥{获取客户端信息}♥ </span>
         * @MethodName: getOAuth2ClientById
         * @author it veteran Jie
         * @param clientId
         * @returned ResultResponse
         * @Date:  | Create 2022/5/25 |
         *         -------------------
         */
    @GetMapping("/api/oauth-clients/getOAuth2ClientById")
    ResultResponse<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId);
}
