package com.boots.mapper;

import com.api.dto.UserAuthDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boots.pojo.SystUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.mapper"}
 * @ClassName: {"classname":"SystUserMapper"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/260:06"}
 */
@SuppressWarnings("all")
@Mapper
public interface SystUserMapper extends BaseMapper<SystUser> {
    @Select("select t1.id userId, t1.username, t1.nickname, t1.password, t1.status, t3.code roleCode \n" +
            "from syst_user t1,syst_user_role t2,syst_role t3\n" +
            "where t1.username = #{userName}\n" +
            "and t1.deleted = 0\n" +
            "and t1.id = t2.user_id\n" +
            "and t2.role_id = t3.id")
    @Results({
            @Result(id = true,column = "userId", property = "userId",jdbcType= JdbcType.BIGINT),
            @Result(column = "username", property = "username",jdbcType= JdbcType.VARCHAR),
            @Result(column = "password", property = "password",jdbcType= JdbcType.VARCHAR),
            @Result(column = "status", property = "status",jdbcType= JdbcType.BOOLEAN),
            @Result(column = "roleCode" ,property = "roles",javaType = List.class,many = @Many(select = "seleByusernameRoleCode"))
    })
    UserAuthDTO getByuserName(@Param("userName") String userName);
    @Select("select syst_role.code  as roleCode  from syst_role where syst_role.code  = #{roleCode}")
    List<String> seleByusernameRoleCode(@Param("roleCode") String roleCode);



}
