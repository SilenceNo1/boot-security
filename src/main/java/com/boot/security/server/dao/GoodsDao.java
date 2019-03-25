package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.security.server.model.Goods;

@Mapper
public interface GoodsDao {

    @Select("select * from t_goods t where t.id = #{id}")
    Goods getById(Long id);

    @Delete("delete from t_goods where id = #{id}")
    int delete(Long id);

    int update(Goods goods);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_goods(goods_no, type, name, price, introduce, video_url, list_image_url, image_id, store_id, specification, stock, cost_price, buying_price, market_price, update_time, create_time,diploma) values(#{goodsNo}, #{type}, #{name}, #{price}, #{introduce}, #{videoUrl}, #{listImageUrl}, #{imageId}, #{storeId}, #{specification}, #{stock}, #{costPrice}, #{buyingPrice}, #{marketPrice}, #{updateTime}, #{createTime},#{diploma})")
    int save(Goods goods);

    int count(@Param("params") Map<String, Object> params);

    List<Goods> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Update("update  t_goods set image_id=#{goodsImagesId} where id = #{goodsId}")
    int updateImageIdById(@Param("goodsId") Integer goodsId, @Param("goodsImagesId") Long goodsImagesId);

    @Update("update  t_goods set store_id=#{storeId} where id in (${ids})")
    int moveStore(@Param("ids") String ids, @Param("storeId") Long storeId);
}
