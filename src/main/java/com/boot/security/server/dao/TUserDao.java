package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.TUser;

@Mapper
public interface TUserDao {

    @Select("select * from t_user t where t.id = #{id}")
    TUser getById(Long id);

    @Delete("delete from t_user where id = #{id}")
    int delete(Long id);

    int update(TUser tUser);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_user(name, nick_name, mobile, password, birthday, sex, email, photo_url, tencent_name, tencent_id, wechat_id, wechat_name, wechat_photourl, sina_id, sina_name, user_code, equity_id, login_days, novice_award, id_card, welfare_status) values(#{name}, #{nickName}, #{mobile}, #{password}, #{birthday}, #{sex}, #{email}, #{photoUrl}, #{tencentName}, #{tencentId}, #{wechatId}, #{wechatName}, #{wechatPhotourl}, #{sinaId}, #{sinaName}, #{userCode}, #{equityId},  #{loginDays}, #{noviceAward}, #{idCard}, #{welfareStatus})")
    int save(TUser tUser);

    int count(@Param("params") Map<String, Object> params);

    List<TUser> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select t.* from t_user t where t.user_code =#{userCode}")
    TUser getByUserCode(Integer userCode);

    @Select("select t.* from t_user t where t.id in (select r.user_id from t_recommend r where r.push_straight = #{userCode})")
    List<TUser> getByPushBetween(String userCode);

    @Select("select * from t_user t where t.mobile = #{mobile}")
    TUser findByMobile(String mobile);

    @Insert("insert into t_user_wallet(user_id) values(#{param1})")
    void saveUser(Long id);

    @Select("select CONCAT_WS(',',user_id,push_straight,push_between) recommends from t_recommend where user_id=#{userId}")
    String findByRecommends(int id);

}
