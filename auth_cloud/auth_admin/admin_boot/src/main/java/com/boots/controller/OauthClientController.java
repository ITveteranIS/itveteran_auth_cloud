package com.boots.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.api.dto.OAuth2ClientDTO;
import com.baomidou.mybatisplus.extension.api.R;
import com.bases.restult.ResultResponse;
import com.boots.pojo.SystOauthClient;
import com.boots.service.ISystOauthClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.controller"}
 * @ClassName: {"classname":"OauthClientController"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/260:03"}
 */
@Api(description = "oauthController", tags = "OauthClientController")
@RestController
@RequestMapping("/api/oauth-clients")
@RequiredArgsConstructor
@SuppressWarnings("all")
public class OauthClientController {
    private final ISystOauthClientService iSystOauthClientService;
    @ApiOperation("获取客户端")
    @GetMapping("/getOAuth2ClientById")
    public ResultResponse<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId) {
        SystOauthClient client = iSystOauthClientService.getByid(clientId);
        Assert.notNull(client, "OAuth2 客户端不存在");
        OAuth2ClientDTO oAuth2ClientDTO = new OAuth2ClientDTO();
        BeanUtil.copyProperties(client, oAuth2ClientDTO);
        return ResultResponse.SUCCESS(oAuth2ClientDTO);
    }
}
