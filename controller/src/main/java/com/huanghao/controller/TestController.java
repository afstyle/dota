package com.huanghao.controller;

import com.huanghao.Result;
import com.huanghao.api.client.OpenDotaApiClient;
import com.huanghao.api.client.OpenDotaApiClientImpl;
import com.huanghao.api.opendota.playerswl.req.PlayersWlRequest;
import com.huanghao.api.opendota.playerswl.rsp.PlayersWlResponse;
import com.huanghao.constant.ApiConstant;
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

    @GetMapping("/ping")
    public String ping() {
        return "ok";
    }


    @GetMapping("/test")
    public Result test() {
        OpenDotaApiClient client = new OpenDotaApiClientImpl(ApiConstant.MY_ACCOUNT_ID);

        PlayersWlRequest playersWlRequest = new PlayersWlRequest();
        playersWlRequest.setLimit(10);
        PlayersWlResponse response = client.execute(playersWlRequest);
        return Result.ok(response);
    }
}
