package com.boots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boots.pojo.SystPermission;
import com.google.protobuf.JavaType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.mapper"}
 * @ClassName: {"classname":"SystPermissionMapper"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/260:07"}
 */
@Mapper
@SuppressWarnings("all")
public interface SystPermissionMapper extends BaseMapper<SystPermission> {

    @Select("SELECT t1.id,t1.NAME,t1.menu_id,t1.url_perm,t3.CODE\n" +
            "FROM syst_permission t1\n" +
            "LEFT JOIN syst_role_permission t2 ON t1.id = t2.permission_id\n" +
            "LEFT JOIN syst_role t3 ON t2.role_id = t3.id")
    @Results({
            @Result(id = true,column = "id",jdbcType = JdbcType.BIGINT),
            @Result(property = "name",column = "name",jdbcType = JdbcType.VARCHAR),
            @Result(property = "menuId",column = "menu_id",jdbcType = JdbcType.BIGINT),
            @Result(property = "urlPerm",column = "url_perm",jdbcType = JdbcType.VARCHAR),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "listPermCode")),
    })
    List<SystPermission> listPermRoles();

    @Select(" SELECT t3.code  as roleCode \n" +
            "FROM syst_permission t1\n" +
            "LEFT JOIN syst_role_permission t2 ON t1.id = t2.permission_id\n" +
            "LEFT JOIN syst_role t3 ON t2.role_id = t3.id where  t1.id =#{id}")
    List<String> listPermCode(Long id);

    @Select("SELECT *  FROM syst_permission t1\n" +
            "LEFT JOIN syst_role_permission t2 ON t1.id = t2.permission_id\n" +
            "LEFT JOIN syst_role t3 ON t2.role_id = t3.id where  t3.code =#{role}")
    boolean nameRole(String role);

}
