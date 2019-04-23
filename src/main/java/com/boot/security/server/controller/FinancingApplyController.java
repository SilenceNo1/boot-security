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
import com.boot.security.server.dao.FinancingApplyDao;
import com.boot.security.server.model.FinancingApply;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/financingApplys")
public class FinancingApplyController {

    @Autowired
    private FinancingApplyDao financingApplyDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public FinancingApply save(@RequestBody FinancingApply financingApply) {
        financingApplyDao.save(financingApply);

        return financingApply;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public FinancingApply get(@PathVariable Long id) {
        return financingApplyDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public FinancingApply update(@RequestBody FinancingApply financingApply) {
        financingApplyDao.update(financingApply);

        return financingApply;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return financingApplyDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<FinancingApply> list(PageTableRequest request) {
                return financingApplyDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        financingApplyDao.delete(id);
    }
}
