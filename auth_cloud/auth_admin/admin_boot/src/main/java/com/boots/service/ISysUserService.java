package com.boots.service;

import com.api.dto.UserAuthDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boots.pojo.SystUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.service"}
 * @ClassName: {"classname":"ISysUserService"}
 * @Description: TODO {"description":"用户业务接口"} 0_0
 * @Date : Create in {"date":"2022/5/260:12"}
 */
public interface ISysUserService extends IService<SystUser> {
     UserAuthDTO getByuserName(String userName);
     List<String> seleByusernameRoleCode(@Param("userName") String userName);
}
