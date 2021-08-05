package com.huanghao.api.client;

import com.huanghao.api.opendota.AbstractResponse;
import com.huanghao.api.opendota.OpenDotaRequest;

/**
 * @author HuangHao
 * @date 2021/8/5 0:20
 */
public interface OpenDotaApiClient {

    <T extends AbstractResponse> T execute(OpenDotaRequest<T> request);

}
