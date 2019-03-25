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
import com.boot.security.server.dao.UserEquityDao;
import com.boot.security.server.model.UserEquity;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userEquitys")
public class UserEquityController {

    @Autowired
    private UserEquityDao userEquityDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public UserEquity save(@RequestBody UserEquity userEquity) {
        userEquityDao.save(userEquity);

        return userEquity;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public UserEquity get(@PathVariable Long id) {
        return userEquityDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public UserEquity update(@RequestBody UserEquity userEquity) {
        userEquityDao.update(userEquity);

        return userEquity;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return userEquityDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<UserEquity> list(PageTableRequest request) {
                return userEquityDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        userEquityDao.delete(id);
    }
}
