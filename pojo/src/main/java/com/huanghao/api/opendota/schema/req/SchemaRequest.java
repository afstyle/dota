package com.huanghao.api.opendota.schema.req;

import com.huanghao.api.opendota.AbstractRequest;
import com.huanghao.api.opendota.OpenDotaRequest;
import com.huanghao.api.opendota.schema.rsp.SchemaResponse;
import com.huanghao.enums.ApiPathEnum;

import java.util.Map;

/**
 * @author HuangHao
 * @date 2021/8/6 2:41
 */
public class SchemaRequest extends AbstractRequest implements OpenDotaRequest<SchemaResponse> {
    @Override
    public ApiPathEnum getApiPathEnum() {
        return ApiPathEnum.SCHEMA;
    }

    @Override
    public Map<String, Object> getParamsMap() {
        return null;
    }

    @Override
    public Class<SchemaResponse> getResponseClass() {
        return SchemaResponse.class;
    }
}
