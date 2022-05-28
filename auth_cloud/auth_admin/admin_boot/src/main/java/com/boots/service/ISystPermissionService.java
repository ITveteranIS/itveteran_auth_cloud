package com.boots.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boots.pojo.SystPermission;

import java.util.List;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.service"}
 * @ClassName: {"classname":"ISystPermissionService"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2616:44"}
 */
@SuppressWarnings("all")
public interface ISystPermissionService extends IService<SystPermission> {
    List<SystPermission> listPermRoles();
    Boolean refreshPermRolesRules();
    boolean nameRole(String role);
}
