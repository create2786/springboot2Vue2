package com.lyw.springbootadmin.controller.rxd;

import com.lyw.springbootadmin.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
// 接收前端登录请求参数
public class UserRXD {
    private String username;
    private String password;
    private String nickname;
    private String headPortrait;
    private String token;
    //查询出所有的菜单项,角色
    private String role;
    private List<Menu> menus;
}
