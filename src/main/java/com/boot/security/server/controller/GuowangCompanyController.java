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
import com.boot.security.server.dao.GuowangCompanyDao;
import com.boot.security.server.model.GuowangCompany;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/guowangCompanys")
public class GuowangCompanyController {

    @Autowired
    private GuowangCompanyDao guowangCompanyDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public GuowangCompany save(@RequestBody GuowangCompany guowangCompany) {
        guowangCompanyDao.save(guowangCompany);

        return guowangCompany;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public GuowangCompany get(@PathVariable Long id) {
        return guowangCompanyDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public GuowangCompany update(@RequestBody GuowangCompany guowangCompany) {
        guowangCompanyDao.update(guowangCompany);

        return guowangCompany;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return guowangCompanyDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<GuowangCompany> list(PageTableRequest request) {
                return guowangCompanyDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        guowangCompanyDao.delete(id);
    }
}
