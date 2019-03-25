package com.boot.security.server.controller;

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

import com.boot.security.server.dao.GoodsDao;
import com.boot.security.server.dao.GoodsImagesDao;
import com.boot.security.server.model.GoodsImages;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodsImagess")
public class GoodsImagesController {

    @Autowired
    private GoodsImagesDao goodsImagesDao;

    @Autowired
    private GoodsDao goodsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public GoodsImages save(@RequestBody GoodsImages goodsImages) {
        goodsImagesDao.save(goodsImages);
        return goodsImages;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public GoodsImages get(@PathVariable Long id) {
        return goodsImagesDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public GoodsImages update(@RequestBody GoodsImages goodsImages) {
        if (goodsImages.getId() == null || goodsImages.getId() == 0) {
            if (goodsImages.getGoodsId() != null && goodsImages.getGoodsId() > 0) {
                int goodsImagesId = goodsImagesDao.save(goodsImages);
                goodsDao.updateImageIdById(goodsImages.getGoodsId(), goodsImages.getId());
            }

        } else {
            goodsImagesDao.update(goodsImages);
        }

        return goodsImages;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsImagesDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<GoodsImages> list(PageTableRequest request) {
                return goodsImagesDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodsImagesDao.delete(id);
    }
}
