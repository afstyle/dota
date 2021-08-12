package com.huanghao.api.client;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.huanghao.api.opendota.AbstractResponse;
import com.huanghao.api.opendota.OpenDotaRequest;
import com.huanghao.constant.ApiConstant;
import com.huanghao.enums.ApiPathEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author HuangHao
 * @date 2021/8/5 0:20
 */
@Slf4j
public class OpenDotaApiClientImpl implements OpenDotaApiClient {

    private static final Integer TIMEOUT = 1000;
    private Long accountId;
    private Long matchId;

    public OpenDotaApiClientImpl(Long accountId, Long matchId) {
        this.accountId = accountId;
        this.matchId = matchId;
    }

    public OpenDotaApiClientImpl(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public <T extends AbstractResponse> T execute(OpenDotaRequest<T> request) {
        log.info("[openDotaApi-get]入参request={}", request);

        Map<String, Object> paramMap = request.getParamsMap();
        ApiPathEnum apiPathEnum = request.getApiPathEnum();

        String url = this.buildUrl(request);

        log.info("[openDotaApi-get]url={}, paramMap={}", url, paramMap);
        String result = HttpUtil.get(url, paramMap, TIMEOUT);
        log.info("[openDotaApi-get]result={}", result);

        return this.parse(result, request.getResponseClass(), apiPathEnum);
    }

    private <T extends AbstractResponse> T parse(String rsp, Class<T> responseClass, ApiPathEnum apiPathEnum) {
        if (apiPathEnum == ApiPathEnum.SCHEMA) {
            return (T) this.parseList(rsp, responseClass);
        } else {
            return this.parseObj(rsp, responseClass);
        }
    }

    private <T extends AbstractResponse> T parseObj(String rsp, Class<T> responseClass) {
        return JSONUtil.toBean(rsp, responseClass);
    }

    private <T extends AbstractResponse> List<T> parseList(String rsp, Class<T> responseClass) {
        return JSONUtil.toList(rsp, responseClass);
    }

    private <T extends AbstractResponse> String buildUrl(OpenDotaRequest<T> request) {
        Long accountId = this.accountId;
        Long matchId = this.matchId;
        ApiPathEnum apiPathEnum = request.getApiPathEnum();

        StringBuilder urlSb = new StringBuilder(ApiConstant.OPEN_DOTA_API_BASE_URL);
        String path = apiPathEnum.getPath();
        if (matchId != null) {
            path = path.replace(ApiConstant.OPEN_DOTA_API_URL_MATCH_ID, matchId.toString());
        }
        if (accountId != null) {
            path = path.replace(ApiConstant.OPEN_DOTA_API_URL_ACCOUNT_ID, accountId.toString());
        }
        urlSb.append(path);
        return urlSb.toString();
    }
}
