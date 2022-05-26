package com.gateway.util;

import cn.hutool.json.JSONUtil;
import com.bases.restult.RestEnum;
import com.bases.restult.ResultResponse;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.gateway.util"}
 * @ClassName: {"classname":"ResponseUtils"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2520:07"}
 */
public class ResponseUtils {
    public static Mono<Void> writeErrorInfo(ServerHttpResponse response, RestEnum resultCode) {
        switch (resultCode) {
            case ACCESS_UNAUTHORIZED:
            case TOKEN_INVALID_OR_EXPIRED:
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                break;
            case TOKEN_ACCESS_FORBIDDEN:
                response.setStatusCode(HttpStatus.FORBIDDEN);
                break;
            default:
                response.setStatusCode(HttpStatus.BAD_REQUEST);
                break;
        }
        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getHeaders().set("Access-Control-Allow-Origin", "*");
        response.getHeaders().set("Cache-Control", "no-cache");
        String body = JSONUtil.toJsonStr(ResultResponse.failed(resultCode));
        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(buffer))
                .doOnError(error -> DataBufferUtils.release(buffer));
    }
}
