package com.huanghao.api.opendota.players.rsp;

import lombok.Data;

/**
 * @author HuangHao
 * @date 2021/8/5 1:25
 */
@Data
public class MmrEstimate {

    private Integer estimate;
    private Integer stdDev;
    private Integer n;

}
