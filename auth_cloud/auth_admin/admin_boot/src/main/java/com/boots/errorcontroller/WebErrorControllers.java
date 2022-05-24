package com.boots.errorcontroller;

import com.bases.restult.UrlReturn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.admin.errorcontroller"}
 * @ClassName: {"classname":"WebErrorControllers"}
 * @Description: TODO {"description":"错误返回Controller"} 0_0
 * @Date : Create in {"date":"2022/5/1921:35"}
 */
@SuppressWarnings("all")
@RestController
public class WebErrorControllers {
    @RequestMapping(value = UrlReturn.ERROR_400)
    public String error400() {
        return "当前请求无法被服务器理解";
    }

    @RequestMapping(value = UrlReturn.ERROR_403)
    public String error403() {
        return "您当前访问的接口权限不足!请联系管理员";
    }

    @RequestMapping(value = UrlReturn.ERROR_404)
    public String error404() {
        return "当前页面走去旅游了，不在家 请您稍后访问";
    }

    @RequestMapping(value = UrlReturn.ERROR_500)
    public String error500() {
        return "服务器内部错误，请稍后访问";
    }

    @RequestMapping(value = UrlReturn.ERROR_415)
    public String error415() {
        return "服务器无法处理请求附带的媒体格式 稍后访问";
    }

    @RequestMapping(value = UrlReturn.ERROR_401)
    public String error401() {
        return "未授权 您没有权限访问 请联系管理员！";
    }
}
