package com.lyw.springbootadmin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyw.springbootadmin.common.Constants;
import com.lyw.springbootadmin.common.Result;
import com.lyw.springbootadmin.controller.rxd.UserRXD;
import com.lyw.springbootadmin.entity.Menu;
import com.lyw.springbootadmin.entity.User;
import com.lyw.springbootadmin.exception.ServiceException;
import com.lyw.springbootadmin.mapper.RoleMapper;
import com.lyw.springbootadmin.mapper.RoleMenuMapper;
import com.lyw.springbootadmin.mapper.UserMapper;
import com.lyw.springbootadmin.service.IMenuService;
import com.lyw.springbootadmin.service.IUserService;
import com.lyw.springbootadmin.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyw
 * @since 2022-10-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private static final Log LOG = Log.get();

    //获取角色唯一标识roleKey
    @Resource
    private RoleMapper roleMapper;
    //角色和菜单的关联关系id
    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private IMenuService menuService;

    @Override
    public UserRXD login(UserRXD userRXD) {
        User alone = getUserData(userRXD);
        if (alone != null) {
            BeanUtil.copyProperties(alone, userRXD, true);
            //设置token
            String token = TokenUtils.genToken(alone.getId().toString(), alone.getPassword());
            userRXD.setToken(token);//登录后会有token
            //获取角色
            String role = alone.getRole();
            //设置用户的菜单列表
            List<Menu> roleMenus = getRoleMenus(role);
            userRXD.setMenus(roleMenus);
            return userRXD;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    //注册
    @Override
    public Result register(UserRXD userRXD) {
        User alone = getUserData(userRXD);
        if (alone == null) {
            alone = new User();//将userDXD数据复制到alone进行插入
            BeanUtil.copyProperties(userRXD, alone, true);
            save(alone);
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名已存在请换一个用户名");
        }
        return Result.success();
    }

    private User getUserData(UserRXD userRXD) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userRXD.getUsername());
        queryWrapper.eq("password", userRXD.getPassword());
//        User alone = getOne(queryWrapper);//查询用户信息用户名只能有一个必须唯一数据库里设置不重复
//        BeanUtil.copyProperties(alone, userRXD, true);//使用hutool用userRXD去copy User里的数据
//        return userRXD;
        User alone;
        try {
            alone = getOne(queryWrapper);
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return alone;
    }

    //获取当前角色的菜单列表
    private List<Menu> getRoleMenus(String roleKey) {
        //获取唯一标识roleKey
        Integer roleId = roleMapper.selectByRoleKey(roleKey);//通过唯一标识roleKey获取到了id
        //根据roleId查询出当前角色所有的menuIds菜单数组
        List<Integer> menuIds = roleMenuMapper.selectByRoleId(roleId);
        //查询出所有菜单
        List<Menu> menus = menuService.findMenus("");//是空的时候不会进行模糊查询
        //筛选当前用户角色的菜单,过滤掉没有筛选的菜单
        List<Menu> roleMenus = new ArrayList<>();
        for (Menu menu : menus) {
            if (menuIds.contains(menu.getId())) {//如果权限菜单id包含pid就展示出来
                roleMenus.add(menu);
            }
            //子菜单
            List<Menu> children = menu.getChildren();
            //如果菜单id不包含子菜单pid就移除
            children.removeIf(child -> !menuIds.contains(child.getId()));
        }
        return roleMenus;
    }
}
