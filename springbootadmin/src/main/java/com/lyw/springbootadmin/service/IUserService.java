package com.lyw.springbootadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyw.springbootadmin.common.Result;
import com.lyw.springbootadmin.controller.rxd.UserRXD;
import com.lyw.springbootadmin.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyw
 * @since 2022-10-28
 */
public interface IUserService extends IService<User> {

    UserRXD login(UserRXD userRXD);

    Result register(UserRXD userRXD);
}
