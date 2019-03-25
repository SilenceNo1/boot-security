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

import com.boot.security.server.dao.StoreDao;
import com.boot.security.server.model.Store;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreDao storeDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Store save(@RequestBody Store store) {
        storeDao.save(store);

        return store;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Store get(@PathVariable Long id) {
        return storeDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Store update(@RequestBody Store store) {
        storeDao.update(store);

        return store;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return storeDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Store> list(PageTableRequest request) {
                return storeDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        storeDao.delete(id);
    }

    @GetMapping("/getAll")
    public List<Store> getAll() {
        return storeDao.getAll();
    }
}
