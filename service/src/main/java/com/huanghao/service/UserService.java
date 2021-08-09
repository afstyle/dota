package com.huanghao.service;

import com.huanghao.bo.b.user.LoginBO;

/**
 * @author HuangHao
 * @date 2021/8/9 23:51
 */
public interface UserService {
    void compareUsernameAndPassword(LoginBO loginBO);
}
