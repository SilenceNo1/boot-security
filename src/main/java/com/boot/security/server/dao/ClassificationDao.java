package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Classification;

@Mapper
public interface ClassificationDao {

    @Select("select * from t_classification t where t.id = #{id}")
    Classification getById(Long id);

    @Delete("delete from t_classification where id = #{id}")
    int delete(Long id);

    int update(Classification classification);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_classification(name, pid, class_image_url, display, class_bigimage_url, grade, class_home_image, update_time, create_time) values(#{name}, #{pid}, #{classImageUrl}, #{display}, #{classBigimageUrl}, #{grade}, #{classHomeImage}, #{updateTime}, #{createTime})")
    int save(Classification classification);

    int count(@Param("params") Map<String, Object> params);

    List<Classification> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from t_classification t order by t.id")
    List<Classification> listAll();

    List<Classification> listByIds(@Param("typeIds") List<Long> typeIds, @Param("grade") Integer grade);
}
