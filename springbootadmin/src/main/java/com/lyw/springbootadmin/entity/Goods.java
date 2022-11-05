package com.lyw.springbootadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

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
@ApiModel(value = "Goods对象", description = "")
@ToString
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品图片")
    private String goodsImg;

    @ApiModelProperty("商品名称")
    private String username;

    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty("货号")
    private String goodsOrder;

    @ApiModelProperty("销量")
    private String goodsSale;


}
