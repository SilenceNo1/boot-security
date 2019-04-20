package com.boot.security.server.model;

import java.util.Date;

public class AuthMessageVerfication extends BaseEntity<Long> {

// 添加时间;
	private Date mesAddtime;
// messageCOde;
	private String mesCode;
// 错误信息;
	private String mesErrorNumber;
// 失效日期;
	private Date mesExpirytime;
// 发送手机号;
	private String mesPhone;

	public Date getMesAddtime() {
		return mesAddtime;
	}
	public void setMesAddtime(Date mesAddtime) {
		this.mesAddtime = mesAddtime;
	}
	public String getMesCode() {
		return mesCode;
	}
	public void setMesCode(String mesCode) {
		this.mesCode = mesCode;
	}
	public String getMesErrorNumber() {
		return mesErrorNumber;
	}
	public void setMesErrorNumber(String mesErrorNumber) {
		this.mesErrorNumber = mesErrorNumber;
	}
	public Date getMesExpirytime() {
		return mesExpirytime;
	}
	public void setMesExpirytime(Date mesExpirytime) {
		this.mesExpirytime = mesExpirytime;
	}
	public String getMesPhone() {
		return mesPhone;
	}
	public void setMesPhone(String mesPhone) {
		this.mesPhone = mesPhone;
	}

}
