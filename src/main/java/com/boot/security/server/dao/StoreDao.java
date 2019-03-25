package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Store;

@Mapper
public interface StoreDao {

    @Select("select * from t_store t where t.id = #{id}")
    Store getById(Long id);

    @Delete("delete from t_store where id = #{id}")
    int delete(Long id);

    int update(Store store);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_store(name, user_id, address, contacts, business_hours, area_name, longitude, latitude, wechat_id, create_time, update_time) values(#{name}, #{userId}, #{address}, #{contacts}, #{businessHours}, #{areaName}, #{longitude}, #{latitude}, #{wechatId}, #{createTime}, #{updateTime})")
    int save(Store store);

    int count(@Param("params") Map<String, Object> params);

    List<Store> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from t_store t")
    List<Store> getAll();
}
