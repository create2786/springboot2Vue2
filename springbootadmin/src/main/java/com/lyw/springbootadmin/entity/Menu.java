package com.lyw.springbootadmin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author lyw
 * @since 2022-11-03
 */
@Getter
@Setter
@TableName("admin_menu")
@ApiModel(value = "Menu对象", description = "")
@ToString
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("菜单名称")
    private String username;

    @ApiModelProperty("菜单路径")
    private String menuPath;

    @ApiModelProperty("菜单图标")
    private String menuIcon;

    @ApiModelProperty("菜单描述")
    private String menuDescribe;
    //在数据库中没有但是在前台展示数据需要树形结构 @TableField(exist=false)数据库忽略
    @TableField(exist = false)
    private List<Menu> children;

    //父级
    private Integer pid;

    
}
