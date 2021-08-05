package com.huanghao.api.opendota.playerswl.rsp;

import cn.hutool.json.JSONUtil;
import com.huanghao.api.opendota.AbstractResponse;
import lombok.Data;

/**
 * @author HuangHao
 * @date 2021/8/5 2:07
 */
@Data
public class PlayersWlResponse extends AbstractResponse {
    private Integer win;
    private Integer lose;

}
