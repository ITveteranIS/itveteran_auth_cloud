package com.sga.controller;

import com.bases.restult.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.controller"}
 * @ClassName: {"classname":"Test"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/252:34"}
 */
@Api(description = "test管理", tags = "TestsController")
@RestController
@RequestMapping("/test")
public class TestsController {
    @ApiOperation("添加订单")
    @GetMapping("/creates")
    public Object create(String o) {
        System.out.println(o);
        System.out.println("-=-=-=-=-=-=-=-=-=-=0=0=0=0=0=0=0-=-=-=-=-=-=-=-=-=");
        return ResultResponse.SUCCESS(o);
    }

}
