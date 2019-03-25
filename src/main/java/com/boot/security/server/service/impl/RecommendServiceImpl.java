package com.boot.security.server.service.impl;

import org.springframework.stereotype.Service;

import com.boot.security.server.model.Recommend;
import com.boot.security.server.service.RecommedService;

@Service
public class RecommendServiceImpl implements RecommedService {

    /**
     * 绑定推荐码
     */
    @Override
    public int bindingUserCode(Recommend r) {
        return 1;
    }

}
