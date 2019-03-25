package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Recommend;

@Mapper
public interface RecommendDao {

    @Select("select * from t_recommend t where t.id = #{id}")
    Recommend getById(Long id);

    @Delete("delete from t_recommend where id = #{id}")
    int delete(Long id);

    int update(Recommend recommend);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_recommend(user_id, push_straight, push_between, three_push, create_time) values(#{userId}, #{pushStraight}, #{pushBetween}, #{threePush}, #{createTime})")
    int save(Recommend recommend);

    int count(@Param("params") Map<String, Object> params);

    List<Recommend> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from t_recommend t where t.user_id = #{userId}")
    Recommend getByUserId(Integer userId);

    @Select("select * from t_recommend t where t.push_straight = #{userCode}")
    List<Recommend> getByPushBetween(String userCode);
}
