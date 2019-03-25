package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.GoodsType;

@Mapper
public interface GoodsTypeDao {

    @Select("select * from t_goods_type t where t.id = #{id}")
    GoodsType getById(Long id);

    @Delete("delete from t_goods_type where id = #{id}")
    int delete(Long id);

    int update(GoodsType goodsType);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_goods_type(goods_id, type_id, type_kind_id, first_type_id, second_type_id, third_type_id, forth_type_id, five_type_id, update_time, create_time) values(#{goodsId}, #{typeId}, #{typeKindId}, #{firstTypeId}, #{secondTypeId}, #{thirdTypeId}, #{forthTypeId}, #{fiveTypeId}, #{updateTime}, #{createTime})")
    int save(GoodsType goodsType);

    int count(@Param("params") Map<String, Object> params);

    List<GoodsType> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from t_goods_type t where t.goods_id = #{goodsId}")
    List<GoodsType> listByGoodsId(Long goodsId);

    @Delete("delete from t_goods_type where goods_id = #{id}")
    void deleteGoodsTypeByGoodsId(Long id);

}
