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

    MATCHES(    1001, "matches/{match_id}", "xx"),

    PLAYERS(    2001, "players/{account_id}", "xx"),
    PLAYERS_WL( 2002, "players/{account_id}/wl", "xx"),

    SCHEMA(     9999, "schema", "基础数据表结构"),
    ;


    private Integer code;
    private String path;
    private String desc;


}
