//package com.sga.securit.datails.user;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.io.Serializable;
//import java.util.Collection;
//
///**
// * @author : ITveteran•JIE
// * @version 1.0x
// * @Package: {"packageName":"com.sga.securit.datails.user"}
// * @ClassName: {"classname":"SysUserDatails"}
// * @Description: TODO {"description":"用户对象封装"} 0_0
// * @Date : Create in {"date":"2022/5/2417:46"}
// */
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@SuppressWarnings("all")
//public class SysUserDatails implements Serializable, UserDetails {
//
//    private Long userId;//扩展字段
//    private String username;//用户名
//    private String password;//密码
//    private Boolean enabled;//是否启用
//    private Collection<SimpleGrantedAuthority> authorities;//用户角色权限
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//}
//
