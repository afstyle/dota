package com.huanghao.service;

import com.huanghao.bo.b.user.LoginBO;
import com.huanghao.pojo.BUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HuangHao
 * @since 2021-08-10
 */
public interface BUserService extends IService<BUser> {
    String compareUsernameAndPassword(LoginBO loginBO);

}
