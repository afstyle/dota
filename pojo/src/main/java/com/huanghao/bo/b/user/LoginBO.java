package com.huanghao.bo.b.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author HuangHao
 * @date 2021/8/9 23:32
 */
@Data
public class LoginBO {

    @NotBlank
    @Length(max = 20)
    private String username;
    @NotBlank
    @Length(max = 20)
    private String password;
}
