package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.GuowangOrder;

@Mapper
public interface GuowangOrderDao {

    @Select("select * from guowang_order t where t.id = #{id}")
    GuowangOrder getById(Long id);

    @Delete("delete from guowang_order where id = #{id}")
    int delete(Long id);

    int update(GuowangOrder guowangOrder);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into guowang_order(no, merchant_name, shop_no, shop_name, buy_no, order_no, ERP_order_no, order_status, pay_status, delivery_status, buy_order_time, order_create_time, pay_time, send_time, send_received_time, invoice_time, invoice_received_time, received_confirm, buyer, buyer_phone, receiver, receiver_phone, company_no, company_name, province_company_no, province_company_name, province_net_name, order_type, factory_name, receive_address, order_message, bak, order_money, pay_money, goods_delivery_company, delivery_no, invoice_type, invoice_titile, invoice_content, send_type, invoice_delivery_company, invoice_delivery_no, type, secend_type, source) values(#{no}, #{merchantName}, #{shopNo}, #{shopName}, #{buyNo}, #{orderNo}, #{ERPOrderNo}, #{orderStatus}, #{payStatus}, #{deliveryStatus}, #{buyOrderTime}, #{orderCreateTime}, #{payTime}, #{sendTime}, #{sendReceivedTime}, #{invoiceTime}, #{invoiceReceivedTime}, #{receivedConfirm}, #{buyer}, #{buyerPhone}, #{receiver}, #{receiverPhone}, #{companyNo}, #{companyName}, #{provinceCompanyNo}, #{provinceCompanyName}, #{provinceNetName}, #{orderType}, #{factoryName}, #{receiveAddress}, #{orderMessage}, #{bak}, #{orderMoney}, #{payMoney}, #{goodsDeliveryCompany}, #{deliveryNo}, #{invoiceType}, #{invoiceTitile}, #{invoiceContent}, #{sendType}, #{invoiceDeliveryCompany}, #{invoiceDeliveryNo}, #{type}, #{secendType}, #{source})")
    int save(GuowangOrder guowangOrder);
    
    int count(@Param("params") Map<String, Object> params);

    List<GuowangOrder> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
