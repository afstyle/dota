package com.huanghao.api.opendota;

import lombok.Data;

/**
 * @author HuangHao
 * @date 2021/8/5 1:34
 */
public interface OpenDotaConvert<T> {

    T convertResultString2Response(String resultString);

}
