package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.security.server.dao.ClassificationDao;
import com.boot.security.server.dao.GoodsTypeDao;
import com.boot.security.server.dto.TypeDto;
import com.boot.security.server.model.Classification;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.GoodsType;
import com.boot.security.server.service.GoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Autowired
    private ClassificationDao classificationDao;

    @Override
    @Transactional
    public void saveGoodsType(TypeDto typeDto) {
        Goods goods = typeDto;
        List<Long> typeIds = typeDto.getTypeIds();
        // typeIds.remove(0L);

        if (goods.getId() != null) {// 修改
            updateGoodsType(goods, typeIds);
        }

    }

    private void updateGoodsType(Goods goods, List<Long> typeIds) {
        goodsTypeDao.deleteGoodsTypeByGoodsId(goods.getId());
        List<Classification> classifications = classificationDao.listByIds(typeIds, 2);
        List<Classification> lastClassifications = classificationDao.listByIds(typeIds, 4);
        for (int i = 0; i < classifications.size(); i++) {
            GoodsType goodsType = new GoodsType();
            goodsType.setGoodsId(goods.getId().intValue());
            goodsType.setTypeId(classifications.get(i).getPid().intValue());
            goodsType.setTypeKindId(classifications.get(i).getId().intValue());
            for (int j = 0; j < lastClassifications.size(); j++) {
                if (lastClassifications.get(j).getId().toString().contains(classifications.get(i).getId().toString())) {
                    if (lastClassifications.get(j).getPid().toString().endsWith("1")) {
                        goodsType.setFirstTypeId(lastClassifications.get(j).getId().intValue());
                    }
                    if (lastClassifications.get(j).getPid().toString().endsWith("2")) {
                        goodsType.setSecondTypeId(lastClassifications.get(j).getId().intValue());
                    }
                    if (lastClassifications.get(j).getPid().toString().endsWith("3")) {
                        goodsType.setThirdTypeId(lastClassifications.get(j).getId().intValue());
                    }
                    if (lastClassifications.get(j).getPid().toString().endsWith("4")) {
                        goodsType.setForthTypeId(lastClassifications.get(j).getId().intValue());
                    }
                    if (lastClassifications.get(j).getPid().toString().endsWith("5")) {
                        goodsType.setFiveTypeId(lastClassifications.get(j).getId().intValue());
                    }

                }
            }
            goodsTypeDao.save(goodsType);

        }

    }

}
