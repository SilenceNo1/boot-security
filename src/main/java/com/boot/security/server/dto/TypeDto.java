package com.boot.security.server.dto;

import java.util.List;

import com.boot.security.server.model.Goods;

public class TypeDto extends Goods {

    private static final long serialVersionUID = 4218495592167610193L;

    private List<Long> typeIds;

    public List<Long> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(List<Long> typeIds) {
        this.typeIds = typeIds;
    }

}
