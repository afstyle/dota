package com.huanghao.api.opendota;

import com.huanghao.enums.ApiPathEnum;

import java.util.Map;

/**
 * @author HuangHao
 * @date 2021/8/6 0:56
 */
public interface OpenDotaRequest<T> {

    ApiPathEnum getApiPathEnum();
    Map<String, Object> getParamsMap();
    Class<T> getResponseClass();
}
