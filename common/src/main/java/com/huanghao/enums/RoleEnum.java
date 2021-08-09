package com.huanghao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HuangHao
 * @date 2021/8/9 23:46
 */
@AllArgsConstructor
@Getter
public enum RoleEnum {
    GENERAL_USER(0, "普通用户"),
    ADMIN(1, "管理员"),
    SUPER_ADMIN(2, "超级管理员"),
    ;

    private Integer code;
    private String desc;
}
