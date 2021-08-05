package com.huanghao.api.opendota.players.rsp;

import lombok.Data;

/**
 * @author HuangHao
 * @date 2021/8/5 1:24
 */
@Data
public class Profile {

    private Integer accountId;
    private String personaname;
    private String name;
    private Boolean plus;
    private Integer cheese;
    private String steamid;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private String profileurl;
    private String lastLogin;
    private String loccountrycode;
    private Boolean isContributor;

}
