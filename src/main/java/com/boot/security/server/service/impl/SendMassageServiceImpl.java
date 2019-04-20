package com.boot.security.server.service.impl;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;
import com.boot.security.server.dao.AuthMessageVerficationDao;
import com.boot.security.server.model.AuthMessageVerfication;
import com.boot.security.server.service.SendMassageService;
import com.boot.security.server.utils.SmsUtil;

@Service
public class SendMassageServiceImpl implements SendMassageService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private AuthMessageVerficationDao authMessageVerficationDao;

	@Override
	public int SendSms(String phone) throws ClientException {
		int code = (int) ((Math.random() * 9 + 1) * 1000);
		SmsUtil.sendSms(phone, code);
		AuthMessageVerfication authMessageVerfication = new AuthMessageVerfication();
		authMessageVerfication.setCreateTime(new Date());
		authMessageVerfication.setMesCode(code + "");
		authMessageVerfication.setMesExpirytime(DateUtils.addMinutes(new Date(), 5));
		authMessageVerfication.setMesPhone(phone);
		return authMessageVerficationDao.save(authMessageVerfication);
	}

}
