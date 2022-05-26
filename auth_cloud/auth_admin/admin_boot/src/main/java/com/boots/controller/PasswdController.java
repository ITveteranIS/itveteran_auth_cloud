package com.boots.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.bases.restult.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.controller"}
 * @ClassName: {"classname":"PasswdController"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/260:03"}
 */
@Api(description = "密码Controller", tags = "PasswdController")
@RestController
@RequestMapping("/passwd")
@RequiredArgsConstructor
@SuppressWarnings("all")
public class PasswdController {
    private final PasswordEncoder passwordEncoder;
    @ApiOperation("获取密码")
    @RequestMapping(value = "/genPasswd/{passwd}",method = RequestMethod.POST)
    public ResultResponse<String> genPasswd(@PathVariable("passwd") String passwd){
        return ResultResponse.SUCCESS(passwordEncoder.encode(passwd));
    }
}
