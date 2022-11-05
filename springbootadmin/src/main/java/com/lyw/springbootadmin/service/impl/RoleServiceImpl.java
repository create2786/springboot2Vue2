package com.lyw.springbootadmin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyw.springbootadmin.entity.Menu;
import com.lyw.springbootadmin.entity.Role;
import com.lyw.springbootadmin.entity.RoleMenu;
import com.lyw.springbootadmin.mapper.RoleMapper;
import com.lyw.springbootadmin.mapper.RoleMenuMapper;
import com.lyw.springbootadmin.service.IMenuService;
import com.lyw.springbootadmin.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyw
 * @since 2022-11-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private IMenuService menuService;

    @Transactional
    //事务注解
//    @Override
//    public void setRoleMenu(Integer roleId, List<Integer> menuIds) {
//        //先删除所有绑定关系再新增
//        roleMenuMapper.deleteByRoleId(roleId);
//        //再把前端传过来的菜单id数组绑定到角色id上
//        for (Integer menuId : menuIds) {
//            RoleMenu roleMenu = new RoleMenu();
//            roleMenu.setRoleId(roleId);
//            roleMenu.setMenuId(menuId);
//            roleMenuMapper.insert(roleMenu);
//        }
//    }
//
//    @Override
//    public Object getRoleMenu(Integer roleId) {
//        return null;
//    }
    @Override
    public void setRoleMenu(Integer roleId, List<Integer> menuIds) {

        // 先删除当前角色id所有的绑定关系
        roleMenuMapper.deleteByRoleId(roleId);

        // 再把前端传过来的菜单id数组绑定到当前的这个角色id上去
        List<Integer> menuIdsCopy = CollUtil.newArrayList(menuIds);
        for (Integer menuId : menuIds) {
            Menu menu = menuService.getById(menuId);
            if (menu.getPid() != null && !menuIdsCopy.contains(menu.getPid())) { // 二级菜单 并且传过来的menuId数组里面没有它的父级id
                // 那么我们就得补上这个父级id
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menu.getPid());
                roleMenuMapper.insert(roleMenu);
                menuIdsCopy.add(menu.getPid());
            }
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
    }

    @Override
    public List<Integer> getRoleMenu(Integer roleId) {

        return roleMenuMapper.selectByRoleId(roleId);
    }
}
