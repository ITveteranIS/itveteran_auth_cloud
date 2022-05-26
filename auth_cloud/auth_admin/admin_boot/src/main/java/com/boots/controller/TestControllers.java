package com.boots.controller;

import com.api.dto.UserAuthDTO;
import com.bases.restult.ResultResponse;
import com.boots.pojo.SystUser;
import com.boots.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.controller"}
 * @ClassName: {"classname":"User"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/250:51"}
 */
@Api(description = "test测试", tags = "TestControllers")
@RestController
@RequestMapping("/order")
public class TestControllers {
    private final ISysUserService iSysUserService;
    private SystUser sysUsers = new SystUser();

    public TestControllers(ISysUserService iSysUserService) {
        this.iSysUserService = iSysUserService;
    }

    @ApiOperation("添加订单")
    @PostMapping("/create")
    public Object test(){
        return "感谢访问";
    }

}
