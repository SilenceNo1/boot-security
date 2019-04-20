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
import com.boot.security.server.dao.AuthMessageVerficationDao;
import com.boot.security.server.model.AuthMessageVerfication;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/authMessageVerfications")
public class AuthMessageVerficationController {

    @Autowired
    private AuthMessageVerficationDao authMessageVerficationDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public AuthMessageVerfication save(@RequestBody AuthMessageVerfication authMessageVerfication) {
        authMessageVerficationDao.save(authMessageVerfication);

        return authMessageVerfication;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AuthMessageVerfication get(@PathVariable Long id) {
        return authMessageVerficationDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AuthMessageVerfication update(@RequestBody AuthMessageVerfication authMessageVerfication) {
        authMessageVerficationDao.update(authMessageVerfication);

        return authMessageVerfication;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return authMessageVerficationDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AuthMessageVerfication> list(PageTableRequest request) {
                return authMessageVerficationDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        authMessageVerficationDao.delete(id);
    }
}
