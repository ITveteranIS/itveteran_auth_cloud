package com.boots.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
/**
 * @ClassName: 【 SysUser 】
 * @author  it veteran
 * @Date : Created in 11:27 2021/9/28
 * 全局异常
 */
@SuppressWarnings("all")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "syst_user")
public class SystUser implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private Integer gender;

    private String avatar;

    private String password;

    private String email;

    private Integer status;

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

    @TableField(exist = false)
    private List<Long> roleIds;

    @TableField(exist = false)
    private String roleNames;

    @TableField(exist = false)
    private List<String> roles;


}
