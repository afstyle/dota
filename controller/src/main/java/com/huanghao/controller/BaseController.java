package com.huanghao.controller;

import com.huanghao.constant.RedisKeyConstant;
import com.huanghao.enums.ErrorEnum;
import com.huanghao.pojo.BUser;
import com.huanghao.util.AssertUtil;
import com.huanghao.util.JsonUtil;
import com.huanghao.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;

/**
 * @author HuangHao
 * @date 2021/8/10 0:55
 */
public class BaseController {

    @Resource
    private RedisUtil redisUtil;


}
