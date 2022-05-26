package com.boots.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boots.mapper.SystOauthClientMapper;
import com.boots.pojo.SystOauthClient;
import com.boots.service.ISystOauthClientService;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.service.impl"}
 * @ClassName: {"classname":"SystOauthClientImpl"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2617:04"}
 */
@SuppressWarnings("all")
@Service
@RequiredArgsConstructor
public class SystOauthClientImpl extends ServiceImpl<SystOauthClientMapper, SystOauthClient> implements ISystOauthClientService {

    @Override
    public SystOauthClient getByid(String clientId) {
        return this.baseMapper.getByid(clientId);
    }
}
