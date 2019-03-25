package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.dao.RecommendDao;
import com.boot.security.server.dao.TUserDao;
import com.boot.security.server.dto.SaveUserDto;
import com.boot.security.server.model.Recommend;
import com.boot.security.server.model.TUser;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.RecommedService;
import com.boot.security.server.utils.ShareCodeUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tUsers")
public class TUserController {

    @Autowired
    private TUserDao tUserDao;

    @Autowired
    private RecommendDao recommendDao;

    @Autowired
    private RecommedService recommendServiceImpl;

    @PostMapping
    @ApiOperation(value = "保存")
    public TUser save(@RequestBody SaveUserDto tUser) {
        TUser user = tUserDao.findByMobile(tUser.getMobile());
        if (user == null) {
            tUser.setUserCode(this.randomCode(tUser.getEquityId()));
            tUser.setNickName(tUser.getMobile().substring(tUser.getMobile().length() - 4));
            tUserDao.save(tUser);
            if (tUser.getInviteCode() != null) {
                Recommend recommend = this.findByRecommends(tUser.getInviteCode());
                recommend.setUserId(tUser.getId().intValue());
                recommendDao.save(recommend);
                // int i = recommendServiceImpl.bindingUserCode(recommend);
            } else {
                tUserDao.saveUser(tUser.getId());
            }
        }

        return tUser;
    }

    private Recommend findByRecommends(int id) {
        String recommends = tUserDao.findByRecommends(id);
        recommends = recommends == null ? "" : recommends;
        recommends += ",";
        String[] recommend = recommends.split(",");
        Recommend r = null;
        if (recommend.length == 3) {
            r = new Recommend(Integer.parseInt(recommend[0]), Integer.parseInt(recommend[1]), Integer.parseInt(recommend[2]));
        } else if (recommend.length == 2) {
            r = new Recommend(Integer.parseInt(recommend[0]), Integer.parseInt(recommend[1]));
        } else if (recommend.length == 1 && recommend != null) {
            r = new Recommend(Integer.parseInt(recommend[0]));
        } else {
            r = new Recommend();
        }
        return r;
    }

    /**
     * 随机生成邀请码
     * 
     * @param username
     * @return
     */
    private String randomCode(int id) {
        String userCode = ShareCodeUtil.toSerialCode(id);
        Map<String, Object> params = new HashMap<>();
        params.put("userCode", userCode);
        int count = tUserDao.count(params);
        if (count == 0) {
            return userCode;
        } else {
            return randomCode(id);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public TUser get(@PathVariable Long id) {
        return tUserDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public TUser update(@RequestBody TUser tUser) {
        tUserDao.update(tUser);
        return tUser;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return tUserDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<TUser> list(PageTableRequest request) {
                return tUserDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @GetMapping("/relation")
    @ApiOperation(value = "列表")
    public PageTableResponse relationList(PageTableRequest request) {
        Integer userId = Integer.parseInt(request.getParams().get("id").toString());
        String type = request.getParams().get("type").toString();
        List<TUser> users = new ArrayList<>();
        if (type.equals("1")) {
            TUser user = tUserDao.getById(userId.longValue());
            users = tUserDao.getByPushBetween(user.getUserCode());
        } else {
            Recommend recommend = recommendDao.getByUserId(userId);
            if (recommend.getPushStraight() != null) {
                users.add(tUserDao.getByUserCode(recommend.getPushStraight()));
            }
            if (recommend.getPushBetween() != null) {
                users.add(tUserDao.getByUserCode(recommend.getPushBetween()));
            }
            if (recommend.getThreePush() != null) {
                users.add(tUserDao.getByUserCode(recommend.getThreePush()));
            }
        }
        int size = users.size();
        List<TUser> returnUsers = new ArrayList<>();
        returnUsers.addAll(users);
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return size;
            }
        }, new ListHandler() {

            @Override
            public List<TUser> list(PageTableRequest request) {
                return returnUsers;
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        tUserDao.delete(id);
    }
}
