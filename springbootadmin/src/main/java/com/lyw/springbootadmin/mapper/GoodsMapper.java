package com.lyw.springbootadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyw.springbootadmin.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyw
 * @since 2022-11-03
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}
