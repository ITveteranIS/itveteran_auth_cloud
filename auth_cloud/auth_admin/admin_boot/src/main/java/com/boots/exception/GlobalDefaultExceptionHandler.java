package com.boots.exception;

import com.bases.restult.RequestException;
import com.bases.restult.RestEnum;
import com.bases.restult.ResultResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 【 GlobalDefaultExceptionHandler 】
 * @author  it veteran
 * @Date : Created in 11:27 2021/9/28
 * 全局异常
 */
@SuppressWarnings("all")
@ControllerAdvice(basePackages = {"com.boots.controller"})
public class GlobalDefaultExceptionHandler {

    /**
     * <span>@Description:</span><span style="color:yellow"> >>{}<< </span>
     * @author it veteran Jie
     * @param  RequestException
     * @returned   RespBeanReturn
     * @Date: Create 20:01 2021/9/28
     */
    @ExceptionHandler(value = RequestException.class)
    @ResponseBody
    public ResultResponse requestExceptionHandler(RequestException e){
        if(e.getE()!=null) e.printStackTrace();
        return ResultResponse.builder().messages(e.getMsg()).code(e.getCode()).build();
    }
    /**
     * <span>@Description:</span><span style="color:yellow"> >>{参数验证异常}<< </span>
     * @author it veteran Jie
     * @param DataIntegrityViolationException
     * @returned   RespBeanReturn
     * @Date: Create 20:02 2021/9/28
     */
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public ResultResponse requestExceptionHandler(DataIntegrityViolationException e){
        return ResultResponse.builder().messages(RestEnum.SYSTEM_DATA_FAIL.messages).code(RestEnum.SYSTEM_EXECUTION_ERROR.code).build();
    }
    String mess="";
    String m="";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        List<String> message = new ArrayList<>();
        if(e instanceof MethodArgumentNotValidException) {
        MethodArgumentNotValidException exs = (MethodArgumentNotValidException) e;
        BindingResult result = e.getBindingResult();
        String s = "参数验证失败->";
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            mess = errors.get(0).getDefaultMessage();
            m=s+=mess;
         }
        }
        return ResultResponse.builder().code(RestEnum.SYSTEM_PARAM_FAIL.code).messages(m).build();
    }


    /**
     * <span>@Description:</span><span style="color:yellow"> >>{所有异常}<< </span>
     * @author it veteran Jie
     * @param  Exception
     * @returned   RespBeanReturn
     * @Date: Create 20:03 2021/9/28
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse requestExceptionHandler(Exception e){
        e.printStackTrace();
        return ResultResponse.builder().messages("系统出现了一点小问题，正在修复中~").code(RestEnum.SYSTEM_EXECUTION_ERROR.code).build();
    }
}
