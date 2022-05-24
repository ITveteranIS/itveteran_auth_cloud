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

    public synchronized static <T> ResultResponse<T> failed(List<?> list) {
        return build(RestEnum.SYSTEM_EXECUTION_ERROR, null);
    }
    public synchronized static <T> ResultResponse<T> failed(T data) {
        return build(RestEnum.SYSTEM_EXECUTION_ERROR, data);
    }
}
