package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.dao.AuthMessageVerficationDao;
import com.boot.security.server.dao.UserDao;
import com.boot.security.server.dto.UserDto;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.SendMassageService;
import com.boot.security.server.service.UserService;
import com.boot.security.server.utils.SmsUtil;
import com.boot.security.server.utils.UserUtil;
import com.aliyuncs.exceptions.ClientException;
import com.boot.security.server.annotation.LogAnnotation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户相关接口
 * 
 * @author jiaxin 13161618211@163.com
 *
 */
@Api(tags = "用户")

@RestController
public class loginController {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private UserService userService;
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private AuthMessageVerficationDao authMessageVerficationDao;
	
	
	@Autowired
	private SendMassageService sendMassageService;
	
	@ApiOperation(value = "发送验证码")
	@PostMapping("/sendSms")
	public int sendSms(String phone) throws ClientException {
		return sendMassageService.SendSms(phone);
	}
	
	
	@LogAnnotation
	@GetMapping("/regist")
	@ApiOperation(value = "用户注册")
	public SysUser registUser( UserDto userDto) {
		userDto.setUsername(userDto.getPhone());
		SysUser u = userService.getUser(userDto.getUsername());
		if (u != null) {
			throw new IllegalArgumentException(userDto.getUsername() + "已存在");
		}
		int count =authMessageVerficationDao.validatCode(userDto.getSysCode(),userDto.getPhone());
		if (count<=0) {
			throw new IllegalArgumentException(userDto.getUsername() + "短信验证码校验错误");
		}
		ArrayList<Long> roles = new ArrayList<Long>();
		roles.add(2L);
		userDto.setRoleIds(roles);
		return userService.saveUser(userDto);
	}
}
