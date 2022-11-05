package com.lyw.springbootadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyw.springbootadmin.entity.Role;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyw
 * @since 2022-11-03
 */
public interface IRoleService extends IService<Role> {

    void setRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}
