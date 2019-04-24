package com.boot.security.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.boot.security.server.dao.CompanyDao;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.utils.QichachaUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseDataController {

    @Autowired
    private CompanyDao companyDao;

    
    
    
 
    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
    	Map<String, Object> params=request.getParams();
    	params=request.getParams();
    	params.put("pageSize", request.getLimit());
    	params.put("pageIndex", request.getOffset());
    	params.remove("start");
    	params.remove("orderBy");
    	params.remove("draw");
    	params.remove("length");
    	JSONObject result =QichachaUtil.get(params,"/ECIV4/Search");
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                try {
					return result.getJSONObject("Paging").getIntValue("TotalRecords");
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
            }
        }, new ListHandler() {        

            @Override
            public List<HashMap> list(PageTableRequest request) {
                return JSONObject.parseArray(result.getJSONArray("Result").toString(),HashMap.class);
            }
        }).handle(request);
    }
    
     
}
