package com.huanghao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huanghao.bo.b.user.LoginBO;
import com.huanghao.pojo.BUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HuangHao
 * @since 2021-08-10
 */
public interface BUserService extends IService<BUser> {

    /**
     * 根据username获取数据库的user对象
     * @param username 用户名称
     * @return 数据库的user对象
     */
    BUser getBUserByUsername(String username);

    /**
     * 登录方法
     * @param loginBO 登录对象
     * @return token
     */
    String bLogin(LoginBO loginBO);

    /**
     * 登出方法
     * @param token token
     */
    void bLogout(String token);

    /**
     * 根据token取redis中的user对象
     * @param token token
     * @return user对象
     */
    BUser getBUserByToken(String token);

    String getPermissionMenu(String token);

}
