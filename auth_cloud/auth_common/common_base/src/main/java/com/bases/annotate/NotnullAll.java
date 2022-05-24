package com.bases.annotate;

import com.bases.annotate.impl.NotNULLALLValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.util.annotation"}
 * @ClassName: {"classname":"NotnullAll"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/4/2323:47"}
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NotNULLALLValidatorImpl.class)
public @interface NotnullAll {
    String value() default "";

    String message() default "不为空";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
