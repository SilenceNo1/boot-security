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
import com.boot.security.server.dao.RecommendDao;
import com.boot.security.server.model.Recommend;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/recommends")
public class RecommendController {

    @Autowired
    private RecommendDao recommendDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Recommend save(@RequestBody Recommend recommend) {
        recommendDao.save(recommend);

        return recommend;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Recommend get(@PathVariable Long id) {
        return recommendDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Recommend update(@RequestBody Recommend recommend) {
        recommendDao.update(recommend);

        return recommend;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return recommendDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Recommend> list(PageTableRequest request) {
                return recommendDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        recommendDao.delete(id);
    }
}
