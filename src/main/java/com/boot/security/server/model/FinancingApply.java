package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class FinancingApply extends BaseEntity<Long> {

// 用户ID;
	private Integer userId;
// 企业 ID;
	private Integer companyId;
// 申请金额;
	private BigDecimal money;
// 融资期限;
	private String deadline;
// 资金流向;
	private String flowDirection;
// 过去一年业务合同;
	private String serviceCompanyImg;
// 发票;
	private String invoiceImg;
// 银行流水;
	private String accountStatementImg;
// 最近三年审计报告;
	private String auditReportImg;
// 其他资料;
	private String otherImg;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getFlowDirection() {
		return flowDirection;
	}
	public void setFlowDirection(String flowDirection) {
		this.flowDirection = flowDirection;
	}
	public String getServiceCompanyImg() {
		return serviceCompanyImg;
	}
	public void setServiceCompanyImg(String serviceCompanyImg) {
		this.serviceCompanyImg = serviceCompanyImg;
	}
	public String getInvoiceImg() {
		return invoiceImg;
	}
	public void setInvoiceImg(String invoiceImg) {
		this.invoiceImg = invoiceImg;
	}
	public String getAccountStatementImg() {
		return accountStatementImg;
	}
	public void setAccountStatementImg(String accountStatementImg) {
		this.accountStatementImg = accountStatementImg;
	}
	public String getAuditReportImg() {
		return auditReportImg;
	}
	public void setAuditReportImg(String auditReportImg) {
		this.auditReportImg = auditReportImg;
	}
	public String getOtherImg() {
		return otherImg;
	}
	public void setOtherImg(String otherImg) {
		this.otherImg = otherImg;
	}

}
