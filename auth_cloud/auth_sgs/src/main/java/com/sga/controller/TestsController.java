package com.sga.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/creates")
    public Object create(@RequestBody String o) {
        return o;
    }
}
