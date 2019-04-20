package com.boot.security.server.service;

import com.aliyuncs.exceptions.ClientException;

public interface SendMassageService {
 

	/** 
	* @throws ClientException 
	 * @Title: SendSms 
	*/
	int SendSms(String phone) throws ClientException;

}
