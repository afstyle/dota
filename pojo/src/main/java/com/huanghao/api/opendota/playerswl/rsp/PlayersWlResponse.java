package com.huanghao.api.opendota.playerswl.rsp;

import cn.hutool.json.JSONUtil;
import com.huanghao.api.opendota.OpenDotaConvert;
import lombok.Data;

/**
 * @author HuangHao
 * @date 2021/8/5 2:07
 */
@Data
public class PlayersWlResponse implements OpenDotaConvert<PlayersWlResponse> {
    private Integer win;
    private Integer lose;

    @Override
    public PlayersWlResponse convertResultString2Response(String resultString) {
        return JSONUtil.toBean(resultString, PlayersWlResponse.class);
    }
}
