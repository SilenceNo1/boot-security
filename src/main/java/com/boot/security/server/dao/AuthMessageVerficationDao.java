package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AuthMessageVerfication;

@Mapper
public interface AuthMessageVerficationDao {

    @Select("select * from auth_message_verfication t where t.id = #{id}")
    AuthMessageVerfication getById(Long id);

    @Delete("delete from auth_message_verfication where id = #{id}")
    int delete(Long id);

    int update(AuthMessageVerfication authMessageVerfication);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into auth_message_verfication(mes_addtime, mes_code, mes_error_number, mes_expirytime, mes_phone) values(#{mesAddtime}, #{mesCode}, #{mesErrorNumber}, #{mesExpirytime}, #{mesPhone})")
    int save(AuthMessageVerfication authMessageVerfication);
    
    int count(@Param("params") Map<String, Object> params);

    List<AuthMessageVerfication> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
    
    @Select("select count(*) from auth_message_verfication t where t.mes_code = #{sysCode} and mes_phone=#{phone} and mes_expirytime>now()")
	int validatCode(@Param("sysCode")String sysCode, @Param("phone")String phone);

	 
}
