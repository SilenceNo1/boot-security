package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.dao.ClassificationDao;
import com.boot.security.server.dao.GoodsTypeDao;
import com.boot.security.server.dto.TypeDto;
import com.boot.security.server.model.Classification;
import com.boot.security.server.model.GoodsType;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.GoodsTypeService;
import com.boot.security.server.annotation.LogAnnotation;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodsTypes")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Autowired
    private GoodsTypeService goodsTypeServiceImpl;

    @Autowired
    private ClassificationDao classificationDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public GoodsType save(@RequestBody GoodsType goodsType) {
        goodsTypeDao.save(goodsType);

        return goodsType;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public GoodsType get(@PathVariable Long id) {
        return goodsTypeDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public GoodsType update(@RequestBody GoodsType goodsType) {
        goodsTypeDao.update(goodsType);

        return goodsType;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsTypeDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<GoodsType> list(PageTableRequest request) {
                return goodsTypeDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodsTypeDao.delete(id);
    }

    @GetMapping(params = "goodsId")
    @ApiOperation(value = "根据菜单获得所有的分类")
    public List<Classification> listByRoleId(Long goodsId) {
        List<Classification> classifications = new ArrayList<>();
        // 查询所有关联类型
        List<GoodsType> goodsTypes = goodsTypeDao.listByGoodsId(goodsId);
        for (GoodsType goodsType : goodsTypes) {
            Classification classification = new Classification();
            classification.setId(goodsType.getTypeId().longValue());
            classifications.add(classification);
            Classification classification1 = new Classification();
            classification1.setId(goodsType.getTypeKindId().longValue());
            classifications.add(classification1);
            if (goodsType.getFirstTypeId() != null) {
                // 查询父类并添加
                Classification classification3 = classificationDao.getById(goodsType.getFirstTypeId().longValue());
                classifications.add(classification3);
                Classification classification4 = new Classification();
                classification4.setId(classification3.getPid().longValue());
                classifications.add(classification4);
            }
            if (goodsType.getSecondTypeId() != null) {
                // 查询父类并添加
                Classification classification6 = classificationDao.getById(goodsType.getSecondTypeId().longValue());
                classifications.add(classification6);
                Classification classification7 = new Classification();
                classification7.setId(classification6.getPid().longValue());
                classifications.add(classification7);
            }
            if (goodsType.getThirdTypeId() != null) {
                // 查询父类并添加
                Classification classification9 = classificationDao.getById(goodsType.getThirdTypeId().longValue());
                classifications.add(classification9);
                Classification classification10 = new Classification();
                classification10.setId(classification9.getPid().longValue());
                classifications.add(classification10);
            }
            if (goodsType.getForthTypeId() != null) {
                // 查询父类并添加
                Classification classification12 = classificationDao.getById(goodsType.getForthTypeId().longValue());
                classifications.add(classification12);
                Classification classification13 = new Classification();
                classification13.setId(classification12.getPid().longValue());
                classifications.add(classification13);
            }
            if (goodsType.getFiveTypeId() != null) {
                // 查询父类并添加
                Classification classification15 = classificationDao.getById(goodsType.getFiveTypeId().longValue());
                classifications.add(classification15);
                Classification classification16 = new Classification();
                classification16.setId(classification15.getPid().longValue());
                classifications.add(classification16);
            }
        }

        return classifications;
    }

    @LogAnnotation
    @PostMapping("/updateGoodsType")
    @ApiOperation(value = "保存商品类型")
    public void saveRole(@RequestBody TypeDto typeDto) {
        goodsTypeServiceImpl.saveGoodsType(typeDto);
    }
}
