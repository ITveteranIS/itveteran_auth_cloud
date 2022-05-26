package com.boots.service.impl;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bases.constan.GlobalConstants;
import com.boots.mapper.SystPermissionMapper;
import com.boots.pojo.SystPermission;
import com.boots.service.ISystPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.service.impl"}
 * @ClassName: {"classname":"ISystPermissionImpl"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/2616:45"}
 */
@SuppressWarnings("all")
@Service
@RequiredArgsConstructor
public class ISystPermissionImpl extends ServiceImpl<SystPermissionMapper, SystPermission> implements ISystPermissionService {
    private final RedisTemplate redisTemplate;

    @Override
    public List<SystPermission> listPermRoles() {
        return baseMapper.listPermRoles();
    }
     /**
        * <span>Description:</span><span style="color:yellow"> ♥{<per>
            首先 先删除redis中本用户角色权限
            从数据库中获取用户角色权限 放入redis中
        * </per>}♥ </span>
        * @MethodName: refreshPermRolesRules
        * @author it veteran Jie
        * @returned Boolean
        * @Date:  | Create 2022/5/26 |
        *         -------------------
        */
    @Override
    public Boolean refreshPermRolesRules() {
        redisTemplate.delete(Arrays.asList(GlobalConstants.URL_PERM_ROLES_KEY));
        List<SystPermission> permissions = this.listPermRoles();
        if (CollectionUtil.isNotEmpty(permissions)){
            // 初始化URL- 角色规则
            List<SystPermission> urlPermList = permissions.stream()
                    .filter(item-> StrUtil.isNotBlank(item.getUrlPerm()))
                    .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(urlPermList)){
                Map<String, List<String>> urlPermRoles = new HashMap<>();
                urlPermList.stream().forEach(item->{
                    String perm=item.getUrlPerm();
                    List<String> itemRoles = item.getRoles();
                    urlPermRoles.put(perm, itemRoles);
                });
                redisTemplate.opsForHash().putAll(GlobalConstants.URL_PERM_ROLES_KEY, urlPermRoles);
            }
        }
        return Boolean.TRUE;
    }
}
