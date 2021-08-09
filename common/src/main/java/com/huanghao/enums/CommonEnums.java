package com.huanghao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HuangHao
 * @date 2021/8/10 1:17
 */
public class CommonEnums {

    @Getter
    @AllArgsConstructor
    public enum YesOrNoEnum {
        NO(0),
        YES(1),
        ;
        private Integer code;
    }

}
