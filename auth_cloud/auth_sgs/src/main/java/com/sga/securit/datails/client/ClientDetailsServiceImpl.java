package com.sga.securit.datails.client;

import com.api.api.OAuthClientFeignClient;
import com.api.dto.OAuth2ClientDTO;
import com.bases.restult.ResultResponse;
import com.sga.common.enums.PasswordEncoderTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.securit.datails.client"}
 * @ClassName: {"classname":"ClientDetailsServiceImpl"}
 * @Description: TODO {"description":"自定义 ClientDetailsService"} 0_0
 * @Date : Create in {"date":"2022/5/2519:38"}
 */
@Service
@RequiredArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {
    private  final OAuthClientFeignClient oAuthClientFeignClient;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ResultResponse<OAuth2ClientDTO> result=oAuthClientFeignClient.getOAuth2ClientById(clientId);
        System.out.println(result+"-=-=-=-=-=-=-=-=");
        if (ResultResponse.SUCCESS().getCode().equals(result.getCode())){
            OAuth2ClientDTO client =result.getData();
            System.out.println(client+"clientclientclientclientclientclientclient");
            BaseClientDetails clientDetails = new BaseClientDetails(
                    client.getClientId(),
                    client.getResourceIds(),
                    client.getScope(),
                    client.getAuthorizedGrantTypes(),
                    client.getAuthorities(),
                    client.getWebServerRedirectUri()
            );
            clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + client.getClientSecret());
            clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
            clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
            System.out.println(clientDetails+"clientDetailsclientDetailsclientDetailsclientDetails");
            return  clientDetails;
        }else {
            throw  new NoSuchClientException(result.getMessages());
        }
    }
}
