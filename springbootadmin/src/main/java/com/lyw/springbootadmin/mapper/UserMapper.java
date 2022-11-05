package com.lyw.springbootadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyw.springbootadmin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyw
 * @since 2022-10-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
