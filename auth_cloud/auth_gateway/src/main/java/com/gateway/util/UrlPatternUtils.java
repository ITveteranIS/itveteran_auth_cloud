package com.gateway.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.gateway.util"}
 * @ClassName: {"classname":"UrlPatternUtils"}
 * @Description: TODO {"description":"白名单"} 0_0
 * @Date : Create in {"date":"2022/5/2520:07"}
 */
public class UrlPatternUtils {
    public static boolean match(String patternUrl, String requestUrl) {
        if (StrUtil.isBlank(patternUrl) || StrUtil.isBlank(requestUrl)) {
            return false;
        }
        PathMatcher matcher = new AntPathMatcher();
        return matcher.match(patternUrl, requestUrl);
    }

    public static void main(String[] args) {
        System.out.println(match("/a/b/c/**","/a/b/c/d/e"));
    }
}
