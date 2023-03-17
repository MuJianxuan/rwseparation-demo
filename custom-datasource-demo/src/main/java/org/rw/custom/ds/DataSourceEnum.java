package org.rw.custom.ds;

import lombok.Getter;

/**
 * @author Rao
 * @Date 2021/4/18
 **/
@Getter
public enum DataSourceEnum {

    /**
     * 主
     */
    MASTER("master"),
    /**
     * 备
     */
    SLAVE("slave"),
    ;

    private String groupName;

    DataSourceEnum(String groupName){
        this.groupName = groupName;
    }

}
