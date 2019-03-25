package com.boot.security.server.dto;

import java.util.List;

public class GoodsStoreDto {

    private static final long serialVersionUID = -184009306207076712L;

    private List<Long> ids;
    private Long storeId;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

}
