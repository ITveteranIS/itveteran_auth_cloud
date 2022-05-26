package com.boots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boots.pojo.SystOauthClient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.mapper"}
 * @ClassName: {"classname":"SystOauthClientMapper"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/260:08"}
 */
@SuppressWarnings("all")
@Mapper
public interface SystOauthClientMapper extends BaseMapper<SystOauthClient> {
    @Select("select * from syst_oauth_cilent where client_id=#{clientId}")
    SystOauthClient getByid(String clientId);
}
