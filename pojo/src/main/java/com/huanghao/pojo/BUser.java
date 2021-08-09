package com.huanghao.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author HuangHao
 * @date 2021/8/9 23:43
 */
@Data
public class BUser {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Integer gender;
    private Integer role;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleteFlag;

}
