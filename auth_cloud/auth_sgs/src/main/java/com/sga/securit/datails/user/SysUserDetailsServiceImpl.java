package com.sga.securit.datails.user;

import com.api.api.OAuthClientFeignClient;
import com.api.api.UserFeignClient;
import com.api.dto.UserAuthDTO;
import com.bases.restult.RestEnum;
import com.bases.restult.ResultResponse;
import com.sga.common.enums.PasswordEncoderTypeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.sga.securit.datails.user"}
 * @ClassName: {"classname":"SysUserDetailsServiceImpl"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2519:58"}
 */
@Service("sysUserDetailsService")
@Component
@Slf4j
@RequiredArgsConstructor
public class SysUserDetailsServiceImpl implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 后面从管理端获取用户信息
        ResultResponse<UserAuthDTO> result = userFeignClient.getUserByUsername(username);
        System.out.println(result+"resultresultresultresultresultresultresult");
        SysUserDatails userDetails = null;
        if (ResultResponse.SUCCESS().getCode().equals(result.getCode())) {
            UserAuthDTO user = result.getData();
            System.out.println(user+"useruseruseruseruseruseruseruseruseruser");
            if (null != user) {
                userDetails = SysUserDatails.builder()
                        .userId(user.getUserId())
                        .username(user.getUsername())
                        .authorities(handleRoles(user.getRoles()))
                        .enabled(user.getStatus() == 1)
                        .password(PasswordEncoderTypeEnum.BCRYPT.getPrefix() + user.getPassword())
                        .build();
            }
        }
        System.out.println("0000000000000000000000000000000000000000000000");
        System.out.println(userDetails);
        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException(RestEnum.USER_NOT_EXIST.getMessages());
        } else if (!userDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return userDetails;
    }

    private Collection<SimpleGrantedAuthority> handleRoles(List<String> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    private SysUserDatails loadUser(String username){
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        return  SysUserDatails.builder().userId(1L)
                .username(username)
                .enabled(true)
                .authorities(authorities)
                .password(PasswordEncoderTypeEnum.BCRYPT.getPrefix()+new BCryptPasswordEncoder().encode("123456789")).build();
    }
}
