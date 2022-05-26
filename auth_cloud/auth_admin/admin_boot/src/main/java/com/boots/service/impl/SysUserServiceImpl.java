package com.boots.service.impl;

import com.api.dto.UserAuthDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boots.mapper.SystUserMapper;
import com.boots.pojo.SystUser;
import com.boots.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.service.impl"}
 * @ClassName: {"classname":"SysUserServiceImpl"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/260:12"}
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SystUserMapper, SystUser> implements ISysUserService {
    @Autowired
    SystUserMapper systUserMapper;
    @Override
    public UserAuthDTO getByuserName(String userName) {
        return systUserMapper.getByuserName(userName);
    }

    @Override
    public List<String> seleByusernameRoleCode(String userName) {
        return systUserMapper.seleByusernameRoleCode(userName);
    }
}
