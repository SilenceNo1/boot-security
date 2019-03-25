package com.boot.security.server.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserEquity extends BaseEntity<Long> {

// 等级名称;
	private String equityName;
// 分享好友得到的翡翠币数量;
	private Integer equitySharinggain;
// 注册获得翡翠豆数量;
	private Integer equityRegister;
// 注册获得代金券金额;
	private Integer equityCashcoupon;
// 会员购物折扣;
	private BigDecimal equityDiscount;
// 分享得到毛利百分比;
	private BigDecimal equityGrossprofitShare;
// 间接得到毛利百分比;
	private BigDecimal equityGrossprofitIndirect;
// 人脉得到毛利百分比;
	private BigDecimal equityGrossprofitConnection;
// 分享得到补贴;
	private String equitySubsidyShare;
// 分享得到补贴平均值;
	private BigDecimal equitySubsidyShareAverage;
// 间接补贴;
	private BigDecimal equitySubsidyIndirect;
// 人脉补贴;
	private BigDecimal equitySubsidyConnection;
// 翡翠币可用数量;
	private BigDecimal quantitativeRestriction;

	public String getEquityName() {
		return equityName;
	}
	public void setEquityName(String equityName) {
		this.equityName = equityName;
	}
	public Integer getEquitySharinggain() {
		return equitySharinggain;
	}
	public void setEquitySharinggain(Integer equitySharinggain) {
		this.equitySharinggain = equitySharinggain;
	}
	public Integer getEquityRegister() {
		return equityRegister;
	}
	public void setEquityRegister(Integer equityRegister) {
		this.equityRegister = equityRegister;
	}
	public Integer getEquityCashcoupon() {
		return equityCashcoupon;
	}
	public void setEquityCashcoupon(Integer equityCashcoupon) {
		this.equityCashcoupon = equityCashcoupon;
	}
	public BigDecimal getEquityDiscount() {
		return equityDiscount;
	}
	public void setEquityDiscount(BigDecimal equityDiscount) {
		this.equityDiscount = equityDiscount;
	}
	public BigDecimal getEquityGrossprofitShare() {
		return equityGrossprofitShare;
	}
	public void setEquityGrossprofitShare(BigDecimal equityGrossprofitShare) {
		this.equityGrossprofitShare = equityGrossprofitShare;
	}
	public BigDecimal getEquityGrossprofitIndirect() {
		return equityGrossprofitIndirect;
	}
	public void setEquityGrossprofitIndirect(BigDecimal equityGrossprofitIndirect) {
		this.equityGrossprofitIndirect = equityGrossprofitIndirect;
	}
	public BigDecimal getEquityGrossprofitConnection() {
		return equityGrossprofitConnection;
	}
	public void setEquityGrossprofitConnection(BigDecimal equityGrossprofitConnection) {
		this.equityGrossprofitConnection = equityGrossprofitConnection;
	}
	public String getEquitySubsidyShare() {
		return equitySubsidyShare;
	}
	public void setEquitySubsidyShare(String equitySubsidyShare) {
		this.equitySubsidyShare = equitySubsidyShare;
	}
	public BigDecimal getEquitySubsidyShareAverage() {
		return equitySubsidyShareAverage;
	}
	public void setEquitySubsidyShareAverage(BigDecimal equitySubsidyShareAverage) {
		this.equitySubsidyShareAverage = equitySubsidyShareAverage;
	}
	public BigDecimal getEquitySubsidyIndirect() {
		return equitySubsidyIndirect;
	}
	public void setEquitySubsidyIndirect(BigDecimal equitySubsidyIndirect) {
		this.equitySubsidyIndirect = equitySubsidyIndirect;
	}
	public BigDecimal getEquitySubsidyConnection() {
		return equitySubsidyConnection;
	}
	public void setEquitySubsidyConnection(BigDecimal equitySubsidyConnection) {
		this.equitySubsidyConnection = equitySubsidyConnection;
	}
	public BigDecimal getQuantitativeRestriction() {
		return quantitativeRestriction;
	}
	public void setQuantitativeRestriction(BigDecimal quantitativeRestriction) {
		this.quantitativeRestriction = quantitativeRestriction;
	}

}
