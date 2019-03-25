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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boot.security.server.dao.ClassificationDao;
import com.boot.security.server.model.Classification;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/classifications")
public class ClassificationController {

    @Autowired
    private ClassificationDao classificationDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Classification save(@RequestBody Classification classification) {
        classificationDao.save(classification);

        return classification;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Classification get(@PathVariable Long id) {
        return classificationDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Classification update(@RequestBody Classification classification) {
        classificationDao.update(classification);

        return classification;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return classificationDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Classification> list(PageTableRequest request) {
                return classificationDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        classificationDao.delete(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "所有分类")
    public JSONArray All() {
        List<Classification> classificationAll = classificationDao.listAll();
        JSONArray array = new JSONArray();
        setClassificationAllTree(0L, classificationAll, array);

        return array;
    }

    /**
     * 分类树
     * 
     * @param pId
     * @param permissionsAll
     * @param array
     */
    private void setClassificationAllTree(Long pId, List<Classification> classificationAll, JSONArray array) {
        for (Classification per : classificationAll) {
            if (per.getPid().equals(pId)) {
                String string = JSONObject.toJSONString(per);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);

                if (classificationAll.stream().filter(p -> p.getPid().equals(per.getId())).findAny() != null) {
                    JSONArray child = new JSONArray();
                    parent.put("child", child);
                    setClassificationAllTree(per.getId(), classificationAll, child);
                }
            }
        }
    }

}
