package com.bases.restult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedHashMap;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.vo.enums"}
 * @ClassName: {"classname":"RestEnum"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/4/2315:04"}
 */
@SuppressWarnings("all")
@AllArgsConstructor
@ToString
@Getter
public enum RestEnum {
    SYSTEM_PARAM_FAIL(2001, "参数验证失败"),
    SYSTEM_DATA_FAIL(2002, "参数验证异常"),
    ERROR(500, "服务器异常"),
    SUCCESS(1, "成功"),
    SYSTEM_EXECUTION_ERROR(999999, "系统执行出错"),
    USERNAME_OR_PASSWORD_ERROR(100, "用户名或密码错误"),
    USER_NOT_EXIST(101, "用户不存在"),
    CLIENT_AUTHENTICATION_FAILED(212, "客户端认证失败"),
    ACCESS_UNAUTHORIZED(213, "未授权"),
    TOKEN_INVALID_OR_EXPIRED(214, "token非法或失效,[没权限]"),
    TOKEN_ACCESS_FORBIDDEN(215, "token禁止访问[权限不足]"),
    FLOW_LIMITING(210, "系统限流"),
    DEGRADATION(220, "系统功能降级"),
    ABNORMAlACCOUNT(8012,"账户异常"),
    TOEKNINVALIDOREXPIREDHASH(8013,"token 无效或已过期"),
    SERVICE_NO_AUTHORITY(221, "服务未授权"),
    SENTINEL_ERROR(9991,"操作繁忙！！"),
    FORBIDDEN(403, "没有相关权限");

    public final Integer code;
    public final String messages;

    public static LinkedHashMap<Integer, String> getArrayMessage() {
        LinkedHashMap<Integer, String> responseMessages = new LinkedHashMap<>();
        for (RestEnum statusEnum : RestEnum.values()) {
            responseMessages.put(statusEnum.code, statusEnum.messages);
        }
        return responseMessages;
    }


}
