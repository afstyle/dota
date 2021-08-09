package com.huanghao.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.huanghao.bo.b.user.LoginBO;
import com.huanghao.constants.CommonConstant;
import com.huanghao.enums.ErrorEnum;
import com.huanghao.exception.DotaException;
import com.huanghao.pojo.BUser;
import com.huanghao.mapper.BUserMapper;
import com.huanghao.service.BUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public String compareUsernameAndPassword(LoginBO loginBO) {
        BUser bUser = super.getOne(new LambdaQueryWrapper<BUser>()
                .eq(BUser::getUsername, loginBO.getUsername())
                .eq(BUser::getPassword, loginBO.getPassword())
                .eq(BUser::getDeleteFlag, false)
                .last(CommonConstant.LIMIT_ONE)
        );
        if (bUser == null) {
            throw new DotaException(ErrorEnum.NO_AUTH, "登陆失败");
        }
        return IdUtil.fastUUID();
    }
}
