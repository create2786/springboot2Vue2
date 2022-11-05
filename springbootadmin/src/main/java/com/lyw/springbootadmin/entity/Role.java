package com.lyw.springbootadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

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
@TableName("admin_role")
@ApiModel(value = "Role对象", description = "")
@ToString
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("名称")
    private String username;

    @ApiModelProperty("描述")
    private String roleDescribe;


    @ApiModelProperty("唯一标识")
    private String roleKey;
}
