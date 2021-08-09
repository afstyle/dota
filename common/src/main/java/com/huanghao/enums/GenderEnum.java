package com.huanghao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HuangHao
 * @date 2021/8/9 23:46
 */
@AllArgsConstructor
@Getter
public enum GenderEnum {
    UNKNOWN(0, "未知"),
    MAN(1, "男性"),
    WOMAN(2, "女性"),
    ;

    private Integer code;
    private String desc;
}
