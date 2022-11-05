package com.lyw.springbootadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * 角色菜单关系表
 * </p>
 *
 * @author lyw
 * @since 2022-11-05
 */
@Data
@TableName("admin_role_menu")
@ToString
public class RoleMenu {
    private Integer roleId;
    private Integer menuId;
}
