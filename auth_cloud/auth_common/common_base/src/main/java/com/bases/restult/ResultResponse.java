package com.bases.restult;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.vo"}
 * @ClassName: {"classname":"ResultResponse"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/4/2221:25"}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse<T> implements Serializable {
    private  Integer code;
    private  String messages;
    private  T data;

    private final long timestamps = System.currentTimeMillis();

    public synchronized static <T> ResultResponse<T> build(RestEnum statusEnum) {
        return build(statusEnum, null);
    }

    public synchronized static <T> ResultResponse<T> build(RestEnum responseCode, T data) {
        ResultResponse<T> res = new ResultResponse<>();
        res.setCode(responseCode.code);
        res.setMessages(responseCode.messages);
        res.setData(data);
        return res;
    }
    public synchronized static <T> ResultResponse<T> SUCCESS() {
        return build(RestEnum.SUCCESS, null);
    }

    public synchronized static <T> ResultResponse<T> SUCCESS(T data) {
        return build(RestEnum.SUCCESS, data);
    }

    public synchronized static <T> ResultResponse<T> failed() {
        return build(RestEnum.SYSTEM_EXECUTION_ERROR, null);
    }
    public synchronized static <T> ResultResponse<T> failed(T data) {
        return build(RestEnum.SYSTEM_EXECUTION_ERROR, data);
    }
    public synchronized static <T> ResultResponse<T> FAINLEDUSERNAME() {
        return build(RestEnum.USER_NOT_EXIST, null);
    }
    public synchronized static <T> ResultResponse<T> ABNORMAlACCOUNT() {
        return build(RestEnum.ABNORMAlACCOUNT, null);
    }
    public synchronized static <T> ResultResponse<T> TOEKNINVALIDOREXPIREDHASH() {
        return build(RestEnum.TOEKNINVALIDOREXPIREDHASH, null);
    }


    public synchronized static <T> ResultResponse<T> USERNAMEORPASSWORD() {
        return build(RestEnum.USERNAME_OR_PASSWORD_ERROR, null);
    }
    public synchronized static <T> ResultResponse<T> CLIENTAUTHENTICATIONFAILED() {
        return build(RestEnum.CLIENT_AUTHENTICATION_FAILED, null);
    }

    public static <T> ResultResponse<T> failed(IResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }
    private static <T> ResultResponse<T> result(Integer code, String msg, T data) {
        ResultResponse<T> result = new ResultResponse<>();
        result.setCode(code);
        result.setData(data);
        result.setMessages(msg);
        return result;
    }



}
