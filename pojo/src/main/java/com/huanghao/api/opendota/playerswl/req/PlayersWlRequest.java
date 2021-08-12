package com.huanghao.api.opendota.playerswl.req;

import com.huanghao.api.opendota.AbstractRequest;
import com.huanghao.api.opendota.OpenDotaRequest;
import com.huanghao.api.opendota.playerswl.rsp.PlayersWlResponse;
import com.huanghao.enums.ApiPathEnum;
import lombok.Data;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author HuangHao
 * @date 2021/8/5 2:13
 */
@Data
public class PlayersWlRequest extends AbstractRequest implements OpenDotaRequest<PlayersWlResponse> {

    private Integer limit;
    private Integer offset;
    private Integer win;
    private Integer patch;
    private Integer gameMode;
    private Integer lobbyType;
    private Integer region;
    private Integer date;
    private Integer laneRole;
    private Integer heroId;
    private Integer isRadiant;
    private Integer includedAccountId;
    private Integer excludedAccountId;
    private Integer withHeroId;
    private Integer againstHeroId;
    private Integer significant;
    private Integer having;
    private String sort;

    @Override
    public ApiPathEnum getApiPathEnum() {
        return ApiPathEnum.PLAYERS_WL;
    }

    @Override
    public Map<String, Object> getParamsMap() {
        Map<String, Object> map = new TreeMap<>();
        map.put("limit", this.limit);
        map.put("offset", this.offset);
        map.put("win", this.win);
        map.put("patch", this.patch);
        map.put("game_mode", this.gameMode);
        map.put("lobby_type", this.lobbyType);
        map.put("region", this.region);
        map.put("date", this.date);
        map.put("lane_role", this.laneRole);
        map.put("hero_id", this.heroId);
        map.put("is_radiant", this.isRadiant);
        map.put("included_account_id", this.includedAccountId);
        map.put("excluded_account_id", this.excludedAccountId);
        map.put("with_hero_id", this.withHeroId);
        map.put("against_hero_id", this.againstHeroId);
        map.put("significant", this.significant);
        map.put("having", this.having);
        map.put("sort", this.sort);
        return map;
    }

    @Override
    public Class<PlayersWlResponse> getResponseClass() {
        return PlayersWlResponse.class;
    }
}
