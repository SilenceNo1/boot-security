package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.FinancingApply;

@Mapper
public interface FinancingApplyDao {

    @Select("select * from financing_apply t where t.id = #{id}")
    FinancingApply getById(Long id);

    @Delete("delete from financing_apply where id = #{id}")
    int delete(Long id);

    int update(FinancingApply financingApply);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into financing_apply(user_id, company_id, money, deadline, flow_direction, service_company_img, invoice_img, account_statement_img, audit_report_img, other_img, create_time) values(#{userId}, #{companyId}, #{money}, #{deadline}, #{flowDirection}, #{serviceCompanyImg}, #{invoiceImg}, #{accountStatementImg}, #{auditReportImg}, #{otherImg}, #{createTime})")
    int save(FinancingApply financingApply);
    
    int count(@Param("params") Map<String, Object> params);

    List<FinancingApply> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
