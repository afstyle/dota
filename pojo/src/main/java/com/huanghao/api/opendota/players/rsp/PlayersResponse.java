package com.huanghao.api.opendota.players.rsp;

import com.huanghao.api.opendota.AbstractResponse;
import lombok.Data;

/**
 * @author HuangHao
 * @date 2021/8/5 1:26
 */
@Data
public class PlayersResponse extends AbstractResponse {
    private String trackedUntil;
    private String soloCompetitiveRank;
    private String competitiveRank;
    private Integer rankTier;
    private Integer leaderboardRank;
    private MmrEstimate mmrEstimate;
    private Profile profile;
}
