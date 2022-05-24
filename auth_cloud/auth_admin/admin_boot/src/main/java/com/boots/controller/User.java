package com.boots.controller;

import com.api.dto.SystUserDto;
import com.api.group.GroupBy;
import com.boots.pojo.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.controller"}
 * @ClassName: {"classname":"User"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/250:51"}
 */
@Api(description = "用户管理", tags = "User")
@RestController
@RequestMapping("/order")
public class User {

    private  SysUser sysUsers = new SysUser();
    @ApiOperation("添加订单")
    @PostMapping("/create")
    public Object create(@RequestBody @Validated({GroupBy.class, Default.class}) SystUserDto systUserDto) {
//        BeanUtils.copyProperties(systUserDto, sysUsers);
        System.out.println("0-0-0-0-0-0-0-0-0-0-0-0--0-0");
        return systUserDto;
    }
}
