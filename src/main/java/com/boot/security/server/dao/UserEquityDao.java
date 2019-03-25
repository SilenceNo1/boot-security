package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.UserEquity;

@Mapper
public interface UserEquityDao {

    @Select("select * from t_user_equity t where t.id = #{id}")
    UserEquity getById(Long id);

    @Delete("delete from t_user_equity where id = #{id}")
    int delete(Long id);

    int update(UserEquity userEquity);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_user_equity(equity_name, equity_sharinggain, equity_register, equity_cashcoupon, equity_discount, equity_grossprofit_share, equity_grossprofit_indirect, equity_grossprofit_connection, equity_subsidy_share, equity_subsidy_share_average, equity_subsidy_indirect, equity_subsidy_connection, quantitative_restriction, create_time, update_time) values(#{equityName}, #{equitySharinggain}, #{equityRegister}, #{equityCashcoupon}, #{equityDiscount}, #{equityGrossprofitShare}, #{equityGrossprofitIndirect}, #{equityGrossprofitConnection}, #{equitySubsidyShare}, #{equitySubsidyShareAverage}, #{equitySubsidyIndirect}, #{equitySubsidyConnection}, #{quantitativeRestriction}, #{createTime}, #{updateTime})")
    int save(UserEquity userEquity);
    
    int count(@Param("params") Map<String, Object> params);

    List<UserEquity> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
