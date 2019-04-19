package com.boot.security.server.model;



public class GuowangOrder extends BaseEntity<Long> {

// 商户编号;
	private String no;
// 商户名称;
	private String merchantName;
// 店铺编号;
	private String shopNo;
// 店铺名称;
	private String shopName;
// 请购单编号;
	private String buyNo;
// 订单编号;
	private String orderNo;
// ERP订单号;
	private String ERPOrderNo;
// 订单状态;
	private String orderStatus;
// 支付状态;
	private String payStatus;
// 配送状态;
	private String deliveryStatus;
// 请购单生成时间;
	private String buyOrderTime;
// 下单时间;
	private String orderCreateTime;
// 支付时间;
	private String payTime;
// 发货时间;
	private String sendTime;
// 商品妥投时间;
	private String sendReceivedTime;
// 发票申请时间;
	private String invoiceTime;
// 发票妥投时间;
	private String invoiceReceivedTime;
// 确认收货时间;
	private String receivedConfirm;
// 采购人账号;
	private String buyer;
// 采购人电话;
	private String buyerPhone;
// 收货人姓名;
	private String receiver;
// 收货人电话;
	private String receiverPhone;
// 单位编码;
	private String companyNo;
// 单位名称;
	private String companyName;
// 省公司编码;
	private String provinceCompanyNo;
// 省公司名称;
	private String provinceCompanyName;
// 网省简称;
	private String provinceNetName;
// 单据类型;
	private String orderType;
// 工厂名称;
	private String factoryName;
// 收货地址;
	private String receiveAddress;
// 订单留言;
	private String orderMessage;
// 备注;
	private String bak;
// 订单金额;
	private String orderMoney;
// 应付金额;
	private String payMoney;
// 商品物流公司;
	private String goodsDeliveryCompany;
// 商品运单号码;
	private String deliveryNo;
// 发票类型;
	private String invoiceType;
// 发票抬头;
	private String invoiceTitile;
// 发票内容;
	private String invoiceContent;
// 发货方式;
	private String sendType;
// 发票物流公司;
	private String invoiceDeliveryCompany;
// 发票运单号码;
	private String invoiceDeliveryNo;
// 所属分类;
	private String type;
// 二级分类;
	private String secendType;
// 渠道来源;
	private String source;

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getShopNo() {
		return shopNo;
	}
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getBuyNo() {
		return buyNo;
	}
	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getERPOrderNo() {
		return ERPOrderNo;
	}
	public void setERPOrderNo(String ERPOrderNo) {
		this.ERPOrderNo = ERPOrderNo;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getBuyOrderTime() {
		return buyOrderTime;
	}
	public void setBuyOrderTime(String buyOrderTime) {
		this.buyOrderTime = buyOrderTime;
	}
	public String getOrderCreateTime() {
		return orderCreateTime;
	}
	public void setOrderCreateTime(String orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getSendReceivedTime() {
		return sendReceivedTime;
	}
	public void setSendReceivedTime(String sendReceivedTime) {
		this.sendReceivedTime = sendReceivedTime;
	}
	public String getInvoiceTime() {
		return invoiceTime;
	}
	public void setInvoiceTime(String invoiceTime) {
		this.invoiceTime = invoiceTime;
	}
	public String getInvoiceReceivedTime() {
		return invoiceReceivedTime;
	}
	public void setInvoiceReceivedTime(String invoiceReceivedTime) {
		this.invoiceReceivedTime = invoiceReceivedTime;
	}
	public String getReceivedConfirm() {
		return receivedConfirm;
	}
	public void setReceivedConfirm(String receivedConfirm) {
		this.receivedConfirm = receivedConfirm;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getBuyerPhone() {
		return buyerPhone;
	}
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProvinceCompanyNo() {
		return provinceCompanyNo;
	}
	public void setProvinceCompanyNo(String provinceCompanyNo) {
		this.provinceCompanyNo = provinceCompanyNo;
	}
	public String getProvinceCompanyName() {
		return provinceCompanyName;
	}
	public void setProvinceCompanyName(String provinceCompanyName) {
		this.provinceCompanyName = provinceCompanyName;
	}
	public String getProvinceNetName() {
		return provinceNetName;
	}
	public void setProvinceNetName(String provinceNetName) {
		this.provinceNetName = provinceNetName;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getOrderMessage() {
		return orderMessage;
	}
	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public String getGoodsDeliveryCompany() {
		return goodsDeliveryCompany;
	}
	public void setGoodsDeliveryCompany(String goodsDeliveryCompany) {
		this.goodsDeliveryCompany = goodsDeliveryCompany;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceTitile() {
		return invoiceTitile;
	}
	public void setInvoiceTitile(String invoiceTitile) {
		this.invoiceTitile = invoiceTitile;
	}
	public String getInvoiceContent() {
		return invoiceContent;
	}
	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getInvoiceDeliveryCompany() {
		return invoiceDeliveryCompany;
	}
	public void setInvoiceDeliveryCompany(String invoiceDeliveryCompany) {
		this.invoiceDeliveryCompany = invoiceDeliveryCompany;
	}
	public String getInvoiceDeliveryNo() {
		return invoiceDeliveryNo;
	}
	public void setInvoiceDeliveryNo(String invoiceDeliveryNo) {
		this.invoiceDeliveryNo = invoiceDeliveryNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSecendType() {
		return secendType;
	}
	public void setSecendType(String secendType) {
		this.secendType = secendType;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

}
