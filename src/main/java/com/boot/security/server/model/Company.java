package com.boot.security.server.model;



public class Company extends BaseEntity<Long> {

// 用户ID;
	private Long userId;
// 企业名称;
	private String name;
// 统一社会信用代码;
	private Integer no;
// 企业办公地址;
	private String address;
// 法人姓名;
	private String userName;
// 法人身份证号码;
	private Integer cardNo;
// 法人联系方式;
	private String phone;
// 法人银行账户;
	private String bankNo;
// 企业收款账户名称;
	private String receiveName;
// 收款账号;
	private Integer receiveNo;
// 开户行名称;
	private String bankName;
// 法人身份证正面;
	private String idFrontImg;
// 法人身份证反面;
	private String idBackImg;
// 供应商营业执照(三证合一);
	private String tradingCertificateImg;
// 开户许可证;
	private String openAccountImg;
// 企业征信报告;
	private String enterpriseCreditImg;
//  法定代表人征信报告;
	private String corporateCreditImg;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public Integer getReceiveNo() {
		return receiveNo;
	}
	public void setReceiveNo(Integer receiveNo) {
		this.receiveNo = receiveNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIdFrontImg() {
		return idFrontImg;
	}
	public void setIdFrontImg(String idFrontImg) {
		this.idFrontImg = idFrontImg;
	}
	public String getIdBackImg() {
		return idBackImg;
	}
	public void setIdBackImg(String idBackImg) {
		this.idBackImg = idBackImg;
	}
	public String getTradingCertificateImg() {
		return tradingCertificateImg;
	}
	public void setTradingCertificateImg(String tradingCertificateImg) {
		this.tradingCertificateImg = tradingCertificateImg;
	}
	public String getOpenAccountImg() {
		return openAccountImg;
	}
	public void setOpenAccountImg(String openAccountImg) {
		this.openAccountImg = openAccountImg;
	}
	public String getEnterpriseCreditImg() {
		return enterpriseCreditImg;
	}
	public void setEnterpriseCreditImg(String enterpriseCreditImg) {
		this.enterpriseCreditImg = enterpriseCreditImg;
	}
	public String getCorporateCreditImg() {
		return corporateCreditImg;
	}
	public void setCorporateCreditImg(String corporateCreditImg) {
		this.corporateCreditImg = corporateCreditImg;
	}

}
