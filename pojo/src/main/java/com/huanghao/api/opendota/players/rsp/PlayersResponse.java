package com.huanghao.api.opendota.players.rsp;

import cn.hutool.json.JSONUtil;
import com.huanghao.api.opendota.OpenDotaConvert;
import lombok.Data;

/**
 * @author HuangHao
 * @date 2021/8/5 1:26
 */
@Data
public class PlayersResponse implements OpenDotaConvert<PlayersResponse> {
    private String trackedUntil;
    private String soloCompetitiveRank;
    private String competitiveRank;
    private Integer rankTier;
    private Integer leaderboardRank;
    private MmrEstimate mmrEstimate;
    private Profile profile;

    @Override
    public PlayersResponse convertResultString2Response(String resultString) {
        return JSONUtil.toBean(resultString, PlayersResponse.class);
    }
}
