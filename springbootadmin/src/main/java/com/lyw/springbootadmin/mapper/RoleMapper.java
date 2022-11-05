package com.lyw.springbootadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyw.springbootadmin.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyw
 * @since 2022-11-03
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select id from admin_role where role_key = #{role_key}")
    Integer selectByRoleKey(@Param("role_key") String role);
}
