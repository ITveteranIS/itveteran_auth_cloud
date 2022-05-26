package com.redis.util;
import org.springframework.stereotype.Component;
/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.util.redistool"}
 * @ClassName: {"classname":"CacheConstant"}
 * @Description: TODO {"description":"redis 缓存 name ro key"} 0_0
 * @Date : Create in {"date":"2022/5/1922:47"}
 */
@SuppressWarnings("all")
public interface CacheConstant {
    /**
     * <span>Description:</span><span style="color:yellow"> ♥{用户 cache name}♥ </span>
     * @author it veteran Jie
     * @Date: Create 2021-12月-1 周三 13:39:41 +0800
     */
    String USER_CACHE_NAME = "user_cache";
    /**
     * <span>Description:</span><span style="color:yellow"> ♥{用户信息缓存key前缀}♥ </span>
     * @author it veteran Jie
     * @Date: Create 2021-12月-1 周三 13:39:58 +0800
     */
    String USER_CACHE_KEY_PREFIX = "user_";

}
