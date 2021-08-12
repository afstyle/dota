package com.huanghao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author HuangHao
 * @date 2021/8/10 0:16
 */
@AllArgsConstructor
@Getter
public enum ErrorEnum {

    COMMON_ERROR(9999, "请求错误，请稍后重试！"),

    NO_AUTH(1000, "用户未登陆"),
    USERNAME_ERROR(1001, "登录账号不存在或已注销"),
    PASSWORD_ERROR(1002, "登录密码错误"),
    LOGIN_EXPIRED(1003, "登录信息已过期"),

    PARAM_ERROR(2000, "传参不正确"),
    ;

    private Integer code;
    private String message;

    private static final HashMap<Integer, ErrorEnum> ERROR_ENUM_MAP = new HashMap<>(ErrorEnum.values().length);
    static {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            ERROR_ENUM_MAP.put(errorEnum.getCode(), errorEnum);
        }
    }

    public static ErrorEnum getErrorEnumByCode(Integer code) {
        return ERROR_ENUM_MAP.get(code);
    }

}
