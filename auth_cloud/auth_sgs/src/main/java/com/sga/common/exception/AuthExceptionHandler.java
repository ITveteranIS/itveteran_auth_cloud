package com.sga.common.exception;
import com.bases.restult.RestEnum;
import com.bases.restult.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.common.exception"}
 * @ClassName: {"classname":"AuthExceptionHandler"}
 * @Description: TODO {"description":"用户认证异常"} 0_0
 * @Date : Create in {"date":"2022/5/2519:11"}
 */
@RestControllerAdvice
@Slf4j
@Order(-1)
public class AuthExceptionHandler {
    /**
     * 用户不存在
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResultResponse handleUsernameNotFoundException(UsernameNotFoundException e) {
        return ResultResponse.FAINLEDUSERNAME();
    }

    /**
     * 用户名和密码异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidGrantException.class)
    public ResultResponse handleInvalidGrantException(InvalidGrantException e) {
        return ResultResponse.USERNAMEORPASSWORD();
    }

    /**
     * 用户名和密码异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidClientException.class)
    public ResultResponse handleInvalidGrantException(InvalidClientException e) {
        return ResultResponse.CLIENTAUTHENTICATIONFAILED();
    }


    /**
     * 账户异常(禁用、锁定、过期)
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InternalAuthenticationServiceException.class})
    public ResultResponse handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
        System.out.println(e.getMessage());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        return ResultResponse.ABNORMAlACCOUNT();
    }

    /**
     * token 无效或已过期
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidTokenException.class})
    public ResultResponse handleInvalidTokenExceptionException(InvalidTokenException e) {
        System.out.println(e.getMessage());
        System.out.println("-----------------------------------------");
        return ResultResponse.TOEKNINVALIDOREXPIREDHASH();
    }
}
