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
    COMMON_ERROR(1000, "请求错误，请稍后重试！"),
    PARAM_ERROR(1001, "传参不正确"),
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
