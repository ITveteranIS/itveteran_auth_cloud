package com.boots.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boots.pojo.SystOauthClient;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.service"}
 * @ClassName: {"classname":"ISystOauthClientService"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2617:03"}
 */
@SuppressWarnings("all")
public interface ISystOauthClientService extends IService<SystOauthClient> {
    SystOauthClient getByid(String clientId);
}
