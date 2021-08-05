package com.huanghao.api.client;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.huanghao.constants.ApiConstant;
import com.huanghao.enums.ApiPathEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HuangHao
 * @date 2021/8/5 0:20
 */
@Slf4j
public class OpenDotaApiClient {

    private static final Integer TIMEOUT = 1000;


    public static String get(ApiPathEnum apiPathEnum){
        return get(apiPathEnum, null, null);
    }


    public static String get(ApiPathEnum apiPathEnum, Long accountId, Long matchId){
        return get(apiPathEnum, accountId, matchId, null);
    }


    public static String get(ApiPathEnum apiPathEnum, Long accountId, Long matchId, String extraParam) {
        log.info("[openDotaApi-get]入参为apiPathEnum={}, accountId={}, matchId={}, extraParam={}",
                apiPathEnum, accountId, matchId, extraParam);
        StringBuilder pathSb = new StringBuilder(ApiConstant.OPEN_DOTA_API_BASE_URL);
        Map<String, Object> paramMap = new HashMap<String, Object>(16);
        switch (apiPathEnum) {
            case MATCHES:
                pathSb.append(String.format(apiPathEnum.getPath(), matchId));
                break;
            case PLAYERS:
            case PLAYERS_WL:
                pathSb.append(String.format(apiPathEnum.getPath(), accountId));
                break;
            default:
                log.error("[openDotaApi-get]apiPathEnum不对劲");
                return null;
        }
        String path = pathSb.toString();
        log.info("[openDotaApi-get]path={}, paramMap={}", path, JSON.toJSONString(paramMap));
        String result = HttpUtil.get(path, paramMap, TIMEOUT);
        log.info("[openDotaApi-get]result={}", result);

        return result;
    }
}
