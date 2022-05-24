package com.bases.restult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.util.abnormal"}
 * @ClassName: {"classname":"RequestException"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/4/2315:09"}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
public class RequestException extends RuntimeException implements Serializable {
    private Integer code;
    private String msg;
    private Exception e;

    public RequestException(RestEnum responseCode, Exception e) {
        this.code = responseCode.code;
        this.msg = responseCode.messages;
        this.e = e;
    }
    public RequestException(RestEnum responseCode) {
        this.code = responseCode.code;
        this.msg = responseCode.messages;
    }

    public synchronized static RequestException fail(String msg){
        return RequestException.builder().code(RestEnum.SYSTEM_EXECUTION_ERROR.code).msg(msg).build();
    }

    public synchronized static RequestException fail(String msg,Exception e){
        return RequestException.builder().code(RestEnum.SYSTEM_EXECUTION_ERROR.code).msg(msg).e(e).build();
    }

    public synchronized static RequestException fail(Integer code,String msg,Exception e){
        return RequestException.builder().code(code).msg(msg).e(e).build();
    }
}
