package com.huanghao.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.huanghao.bo.b.user.LoginBO;
import com.huanghao.constant.CommonConstant;
import com.huanghao.constant.RedisKeyConstant;
import com.huanghao.enums.ErrorEnum;
import com.huanghao.pojo.BUser;
import com.huanghao.mapper.BUserMapper;
import com.huanghao.service.BUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huanghao.util.AssertUtil;
import com.huanghao.util.CheckUtil;
import com.huanghao.util.JsonUtil;
import com.huanghao.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HuangHao
 * @since 2021-08-10
 */
@Service
public class BUserServiceImpl extends ServiceImpl<BUserMapper, BUser> implements BUserService {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public BUser getBUserByUsername(String username) {
        BUser bUser = super.getOne(new LambdaQueryWrapper<BUser>()
                .eq(BUser::getUsername, username)
                .eq(BUser::getDeleteFlag, false)
                .last(CommonConstant.LIMIT_ONE)
        );
        AssertUtil.assertTrue(bUser == null, ErrorEnum.USERNAME_ERROR);
        return bUser;
    }

    @Override
    public String bLogin(LoginBO loginBO) {
        // 验证登录账号信息是否正确
        BUser bUser = getBUserByUsername(loginBO.getUsername());
        CheckUtil.checkPassword(bUser.getPassword(), loginBO.getPassword());

        // 去敏
        bUser.setPassword(null);

        // 生成token
        String token = IdUtil.fastSimpleUUID();

        // 存入redis
        redisUtil.set(RedisKeyConstant.B_USER_SESSION_KEY + token, JsonUtil.objectToJson(bUser), RedisKeyConstant.B_USER_SESSION_EXPIRE_TIME);

        return token;
    }

    @Override
    public void bLogout(String token) {
        // 删除redis存储的用户信息
        redisUtil.del(RedisKeyConstant.B_USER_SESSION_KEY + token);
    }

    @Override
    public BUser getBUserByToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        String json = redisUtil.get(RedisKeyConstant.B_USER_SESSION_KEY + token);
        AssertUtil.assertTrue(StringUtils.isBlank(json), ErrorEnum.LOGIN_EXPIRED);

        redisUtil.expire(RedisKeyConstant.B_USER_SESSION_KEY + token, RedisKeyConstant.B_USER_SESSION_EXPIRE_TIME);
        return JsonUtil.jsonToPojo(json, BUser.class);
    }

    @Override
    public String getPermissionMenu(String token) {
        return CommonConstant.DEFAULT_MENU;
    }


}
