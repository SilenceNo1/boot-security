package com.boot.security.server.model;

import java.util.Date;

public class GoodsType extends BaseEntity<Long> {

// 商品ID;
	private Integer goodsId;
// 一级分类;
	private Integer typeId;
// 二级分类;
	private Integer typeKindId;
// 第一个类型;
	private Integer firstTypeId;
// 第二个类型;
	private Integer secondTypeId;
// 第三个类型;
	private Integer thirdTypeId;
// 第四个类型;
	private Integer forthTypeId;
// 第五个类型;
	private Integer fiveTypeId;

	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getTypeKindId() {
		return typeKindId;
	}
	public void setTypeKindId(Integer typeKindId) {
		this.typeKindId = typeKindId;
	}
	public Integer getFirstTypeId() {
		return firstTypeId;
	}
	public void setFirstTypeId(Integer firstTypeId) {
		this.firstTypeId = firstTypeId;
	}
	public Integer getSecondTypeId() {
		return secondTypeId;
	}
	public void setSecondTypeId(Integer secondTypeId) {
		this.secondTypeId = secondTypeId;
	}
	public Integer getThirdTypeId() {
		return thirdTypeId;
	}
	public void setThirdTypeId(Integer thirdTypeId) {
		this.thirdTypeId = thirdTypeId;
	}
	public Integer getForthTypeId() {
		return forthTypeId;
	}
	public void setForthTypeId(Integer forthTypeId) {
		this.forthTypeId = forthTypeId;
	}
	public Integer getFiveTypeId() {
		return fiveTypeId;
	}
	public void setFiveTypeId(Integer fiveTypeId) {
		this.fiveTypeId = fiveTypeId;
	}

}
