package com.lyw.springbootadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyw.springbootadmin.entity.Menu;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyw
 * @since 2022-11-03
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> findMenus(String username);
}
