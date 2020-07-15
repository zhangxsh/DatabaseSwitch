package com.alexzhang.dynamic;

import com.alexzhang.constant.Const;
import lombok.Getter;

/**
 * Created by alexzhang on 2017/12/16.
 */
@Getter
public enum Type {

    PRIMARY(Const.DataSourceType.PRIMARY),
    SLAVE(Const.DataSourceType.SLAVE),
    DEFAULT(Const.DataSourceType.PRIMARY),

    ;Type(String name){
        this.name = name;
    }
    private String name;
}
