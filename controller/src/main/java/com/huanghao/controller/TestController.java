package com.huanghao.controller;

import com.huanghao.Result;
import com.huanghao.api.client.OpenDotaApiClient;
import com.huanghao.api.opendota.playerswl.rsp.PlayersWlResponse;
import com.huanghao.constants.ApiConstant;
import com.huanghao.enums.ApiPathEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuangHao
 * @date 2021/8/5 0:52
 */
@RestController
@RequestMapping("")
public class TestController {

    @GetMapping("/test")
    public Result test() {

        final String s = OpenDotaApiClient.get(ApiPathEnum.PLAYERS_WL, ApiConstant.MY_ACCOUNT_ID, null);
        PlayersWlResponse playersBean = new PlayersWlResponse().convertResultString2Response(s);
        return Result.ok(playersBean);
    }
}
