package com.boots.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 *
 * @author：
 * @date： 2021/11/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@SuppressWarnings("all")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName(value = "syst_permission")
public class SystPermission implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Long menuId;

    private String urlPerm;

    // 有权限的角色编号集合
    @TableField(exist = false)
    private List<String> roles;

}
