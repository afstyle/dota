package com.huanghao.api.opendota.schema.rsp;

import com.huanghao.api.opendota.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * @author HuangHao
 * @date 2021/8/6 0:33
 */
@Data
public abstract class SchemaResponse extends AbstractResponse {
    private String tableName;
    private String columnName;
    private String dataType;
}
