package com.boot.security.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.boot.security.server.dao.CompanyDao;
import com.boot.security.server.dto.LoginUser;
import com.boot.security.server.model.Company;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/companys")
public class CompanyController {

    @Autowired
    private CompanyDao companyDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Company save(@RequestBody Company company) {
    	LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext()
    		    .getAuthentication()
    		    .getPrincipal();
    	
    	company.setUserId(loginUser.getId());
        companyDao.save(company);

        return company;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Company get(@PathVariable Long id) {
        return companyDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Company update(@RequestBody Company company) {
    	LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext()
    		    .getAuthentication()
    		    .getPrincipal();
    	
    	company.setUserId(loginUser.getId());
        companyDao.update(company);

        return company;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return companyDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Company> list(PageTableRequest request) {
                return companyDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }
    
    @GetMapping("/my")
    @ApiOperation(value = "我的列表")
    public PageTableResponse mylist(PageTableRequest request) {
    	LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext()
    		    .getAuthentication()
    		    .getPrincipal();
    	
    	Map<String, Object> params =request.getParams();
    	params.put("userId", loginUser.getId());
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return companyDao.count(params);
            }
        }, new ListHandler() {

            @Override
            public List<Company> list(PageTableRequest request) {
                return companyDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        companyDao.delete(id);
    }
}
