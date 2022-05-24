package com.bases.annotate.impl;

import com.bases.annotate.NotnullAll;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.util.annotation.impl"}
 * @ClassName: {"classname":"NotNULLALLValidatorImpl"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/4/2323:48"}
 */
@SuppressWarnings("all")
public class NotNULLALLValidatorImpl implements ConstraintValidator<NotnullAll, String> {
    private String isValue;
    private Boolean isBabbleAll=false;
    @Override
    public void initialize(NotnullAll constraintAnnotation) {
        this.isValue=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (Optional.ofNullable(s).isPresent() && !"".equals(s)) {
            isBabbleAll=Boolean.TRUE;
        }else {
            isBabbleAll=Boolean.FALSE;
        }
        return isBabbleAll;
    }
}
