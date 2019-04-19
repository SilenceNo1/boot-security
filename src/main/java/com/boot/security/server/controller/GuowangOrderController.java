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

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.GuowangOrderDao;
import com.boot.security.server.model.GuowangOrder;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/guowangOrders")
public class GuowangOrderController {

    @Autowired
    private GuowangOrderDao guowangOrderDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public GuowangOrder save(@RequestBody GuowangOrder guowangOrder) {
        guowangOrderDao.save(guowangOrder);

        return guowangOrder;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public GuowangOrder get(@PathVariable Long id) {
        return guowangOrderDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public GuowangOrder update(@RequestBody GuowangOrder guowangOrder) {
        guowangOrderDao.update(guowangOrder);

        return guowangOrder;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return guowangOrderDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<GuowangOrder> list(PageTableRequest request) {
                return guowangOrderDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        guowangOrderDao.delete(id);
    }
}
