package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.GuowangCompany;

@Mapper
public interface GuowangCompanyDao {

    @Select("select * from guowang_company t where t.id = #{id}")
    GuowangCompany getById(Long id);

    @Delete("delete from guowang_company where id = #{id}")
    int delete(Long id);

    int update(GuowangCompany guowangCompany);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into guowang_company(no, name, package_name, company_name, address, tel, email) values(#{no}, #{name}, #{packageName}, #{companyName}, #{address}, #{tel}, #{email})")
    int save(GuowangCompany guowangCompany);
    
    int count(@Param("params") Map<String, Object> params);

    List<GuowangCompany> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
