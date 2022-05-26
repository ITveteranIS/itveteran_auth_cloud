package com.redis.util;

import org.springframework.stereotype.Component;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.util.redistool"}
 * @ClassName: {"classname":"GetCacheKey"}
 * @Description: TODO {"description":"redis 获取 key"} 0_0
 * @Date : Create in {"date":"2022/5/1922:59"}
 */

public interface GetCacheKey {
    /**
     * <span>Description:</span><span style="color:yellow"> ♥{获取用户key}♥ </span>
     * @MethodName: getUserCacheKey
     * @author it veteran Jie
     * @param  suffix 后缀是什么
     * @returned
     * @Date: Create 2021-12月-1 周三 14:07:33 +0800
     */
    static String getUserCacheKey(String suffix) {
        return CacheConstant.USER_CACHE_NAME + "::" + CacheConstant.USER_CACHE_KEY_PREFIX + suffix;
    }
}
