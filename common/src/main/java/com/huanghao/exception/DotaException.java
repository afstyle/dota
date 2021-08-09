package com.huanghao.exception;

import com.huanghao.enums.ErrorEnum;

/**
 * @author HuangHao
 * @date 2021/8/10 0:15
 */
public class DotaException extends RuntimeException {

    private ErrorEnum errorEnum;

    public DotaException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.errorEnum = errorEnum;
    }

    public DotaException(ErrorEnum errorEnum, String message) {
        super(message);
        this.errorEnum = errorEnum;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }
}
