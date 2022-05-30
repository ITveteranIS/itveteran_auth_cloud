package com.boots.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.api.dto.UserAuthDTO;
import com.bases.restult.ResultResponse;
import com.boots.service.ISysUserService;
import com.boots.service.ISystPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.controller"}
 * @ClassName: {"classname":"UserController"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/260:04"}
 */
@Api(description = "用户Controller", tags = "UserController")
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private  final ISysUserService iSysUserService;
    private final ISystPermissionService iSystPermissionService;

    @ApiOperation("获取用户信息")
    @GetMapping("/username/{username}")
    @SentinelResource(value = "selectByname",blockHandlerClass=com.bases.restult.sentinelHandlerconfig.SentinelHandler.class ,blockHandler = "handle")
    public Object getUserByUsername(@PathVariable String username){
        return ResultResponse.SUCCESS(iSysUserService.getByuserName(username));
    }

}
