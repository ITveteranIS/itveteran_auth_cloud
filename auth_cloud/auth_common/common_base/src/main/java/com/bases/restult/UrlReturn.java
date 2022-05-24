package com.bases.restult;

import org.springframework.stereotype.Component;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"it.common.urlsetting"}
 * @ClassName: {"classname":"UrlReturn"}
 * @Description: TODO {"description":"url 设置"} 0_0
 * @Date : Create in {"date":"2022/5/1921:31"}
 */
@Component
@SuppressWarnings("all")
public interface UrlReturn {
     /**
        * <span>Description:</span><span style="color:yellow"> ♥{<pre>
          ERROR_400,ERROR_401,ERROR_403,ERROR_404,ERROR_415,ERROR_500 </br>
          url 错误连接设置
        * </pre>}♥ </span>
        * @author it veteran Jie
        * @Date:  | Create 2022/5/19 |
        *         -------------------
        */
    static final String ERROR_400 = "/error/400";
    static final String ERROR_401 = "/error/401";
    static final String ERROR_403 = "/error/403";
    static final String ERROR_404 = "/error/404";
    static final String ERROR_415 = "/error/415";
    static final String ERROR_500 = "/error/500";
}
