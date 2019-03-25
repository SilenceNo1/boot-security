package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.GoodsImages;

@Mapper
public interface GoodsImagesDao {

    @Select("select * from t_goods_images t where t.id = #{id}")
    GoodsImages getById(Long id);

    @Delete("delete from t_goods_images where id = #{id}")
    int delete(Long id);

    int update(GoodsImages goodsImages);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_goods_images(imageone_url, imagetwo_url, imagethree_url, imagefour_url, imagefive_url, imagesix_url, imageseven_url, imageeight_url, create_time) values(#{imageoneUrl}, #{imagetwoUrl}, #{imagethreeUrl}, #{imagefourUrl}, #{imagefiveUrl}, #{imagesixUrl}, #{imagesevenUrl}, #{imageeightUrl}, #{createTime})")
    int save(GoodsImages goodsImages);
    
    int count(@Param("params") Map<String, Object> params);

    List<GoodsImages> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
