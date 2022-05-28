package com.gateway.security;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.bases.constan.GlobalConstants;
import com.bases.constan.SecurityConstants;
//import com.boots.service.ISystPermissionService;
import com.gateway.util.UrlPatternUtils;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.gateway.security"}
 * @ClassName: {"classname":"ResourceServerManager"}
 * @Description: TODO {"description":"设置白名单"} 0_0
 * @Date : Create in {"date":"2022/5/2520:06"}
 */
@Component
@RequiredArgsConstructor
@Slf4j
@ConfigurationProperties(prefix = "security")
@SuppressWarnings("all")
public class ResourceServerManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    private final RedisTemplate redisTemplate;

    @Setter
    private List<String> ignoreUrls;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();

        if (request.getMethod() == HttpMethod.OPTIONS) { // 预检请求放行
            return Mono.just(new AuthorizationDecision(true));
        }
        PathMatcher pathMatcher = new AntPathMatcher();
        String method = request.getMethodValue();
        String path = request.getURI().getPath();

        // 跳过token校验，放在这里去做是为了能够动态刷新
        if (skipValid(path)) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // 如果token为空 或者token不合法 则进行拦截
        String restfulPath = method + ":" + path; // RESTFul接口权限设计 @link https://www.cnblogs.com/haoxianrui/p/14961707.html
        String token = request.getHeaders().getFirst(SecurityConstants.AUTHORIZATION_KEY);
        if (StrUtil.isBlank(token) || !StrUtil.startWithIgnoreCase(token, SecurityConstants.JWT_PREFIX)) {
            return Mono.just(new AuthorizationDecision(false));
        }
        Map<String, Object> urlPermRolesRules = redisTemplate.opsForHash().entries(GlobalConstants.URL_PERM_ROLES_KEY);
        List<String> authorizedRoles = new ArrayList<>(); // 拥有访问权限的角色
        boolean requireCheck = false; // 是否需要鉴权，默认未设置拦截规则不需鉴权
        // 从redis中获取资源权限
        System.out.println(urlPermRolesRules+"==================================================");

        // 是否需要鉴权，默认未设置拦截规则不需鉴权
        System.out.println(urlPermRolesRules.entrySet());
        // 获取当前资源 所需要的角色
        for (Map.Entry<String, Object> permRoles : urlPermRolesRules.entrySet()) {

            String perm = permRoles.getKey();
            System.out.println(perm+"permpermpermpermpermpermperm");
            System.out.println(pathMatcher.match(perm, restfulPath) +"-------判断访问接口 权限里面是否有");
            if (pathMatcher.match(perm, restfulPath)) {
                System.out.println(restfulPath + "url");
                List<String> roles = Convert.toList(String.class, permRoles.getValue());
                authorizedRoles.addAll(Convert.toList(String.class, roles));
                if (requireCheck ==false){
                    requireCheck = true;
                }
                System.out.println(authorizedRoles+"角色集合");
            }

        }
        if (requireCheck==false){
            return Mono.just(new AuthorizationDecision(false));
        }
        // 如果资源不需要权限 则直接返回授权成功
//        if (!requireCheck) {
//            return Mono.just(new AuthorizationDecision(true));
//        }

        // 判断JWT中携带的用户角色是否有权限访问
        Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authority -> {
                    String roleCode = authority.substring(SecurityConstants.AUTHORITY_PREFIX.length()); // 用户的角色
                    boolean hasAuthorized = CollectionUtil.isNotEmpty(authorizedRoles) && authorizedRoles.contains(roleCode);
                    System.out.println(roleCode+"当前用户角色");
                    System.out.println(hasAuthorized+"判断是否有这个角色");
                    System.out.println(authorizedRoles+"获取出的角色");
                    if (hasAuthorized==true) {
                        System.out.println(hasAuthorized+"hasAuthorizedhasAuthorized");
                    }
                    return hasAuthorized;
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
        return authorizationDecisionMono;
    }
    /**
     * 跳过校验
     *
     * @param path
     * @return
     */
    private boolean skipValid(String path) {
        for (String skipPath : ignoreUrls) {
            if (UrlPatternUtils.match(skipPath, path)) {
                return true;
            }
        }
        return false;
    }

}
