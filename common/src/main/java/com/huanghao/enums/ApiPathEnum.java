package com.huanghao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author HuangHao
 * @date 2021/8/5 0:30
 */
@Getter
@AllArgsConstructor
public enum ApiPathEnum {

    MATCHES(    1001, "/matches/%s", "xx"),

    PLAYERS(    2001, "/players/%s", "xx"),
    PLAYERS_WL( 2002, "/players/%s/wl", "xx"),
    ;


    private Integer code;
    private String path;
    private String desc;


}
