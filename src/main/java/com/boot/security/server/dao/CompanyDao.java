package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Company;

@Mapper
public interface CompanyDao {

    @Select("select * from company t where t.id = #{id}")
    Company getById(Long id);

    @Delete("delete from company where id = #{id}")
    int delete(Long id);

    int update(Company company);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into company(user_id, name, no, address, user_name, card_no, phone, bank_no, receive_name, receive_no, bank_name, id_front_img, id_back_img, trading_certificate_img, open_account_img, enterprise_credit_img, corporate_credit_img) values(#{userId}, #{name}, #{no}, #{address}, #{userName}, #{cardNo}, #{phone}, #{bankNo}, #{receiveName}, #{receiveNo}, #{bankName}, #{idFrontImg}, #{idBackImg}, #{tradingCertificateImg}, #{openAccountImg}, #{enterpriseCreditImg}, #{corporateCreditImg})")
    int save(Company company);
    
    int count(@Param("params") Map<String, Object> params);

    List<Company> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
