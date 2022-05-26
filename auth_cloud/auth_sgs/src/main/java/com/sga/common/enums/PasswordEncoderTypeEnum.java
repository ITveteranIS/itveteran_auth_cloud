package com.sga.common.enums;

import lombok.Getter;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.common"}
 * @ClassName: {"classname":"PasswordEncoderTypeEnum"}
 * @Description: TODO {"description":"PasswordEncoderTypeEnum 密码"} 0_0
 * @Date : Create in {"date":"2022/5/254:10"}
 */
@SuppressWarnings("all")
public enum PasswordEncoderTypeEnum {
    BCRYPT("{bcrypt}","BCRYPT加密"),
    NOOP("{noop}","无加密明文");
    @Getter
    private String prefix;

    PasswordEncoderTypeEnum(String prefix, String desc){
        this.prefix=prefix;
    }
}
