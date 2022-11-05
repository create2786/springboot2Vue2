package com.lyw.springbootadmin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyw.springbootadmin.common.Constants;
import com.lyw.springbootadmin.common.Result;
import com.lyw.springbootadmin.entity.Icons;
import com.lyw.springbootadmin.entity.Menu;
import com.lyw.springbootadmin.mapper.IconsMapper;
import com.lyw.springbootadmin.service.IMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyw
 * @since 2022-11-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private IMenuService menuService;
    @Resource
    private IconsMapper iconsMapper;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Menu menu) {
        menuService.saveOrUpdate(menu);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        menuService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        menuService.removeByIds(ids);
        return Result.success();
    }

//    @GetMapping
//    public Result findAll() {
//        return Result.success(menuService.list());
//    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(menuService.getById(id));
    }

    // 建立查询关联获取一级菜单父类
    @GetMapping
    public Result findAll(@RequestParam(defaultValue = "") String username) {
        return Result.success(menuService.findMenus(username));
    }

    //请求icons
    @GetMapping("/icons")
    public Result getIcons() {
        QueryWrapper<Icons> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("icon_type", Constants.DICT_TYPE_ICON);
        return Result.success(iconsMapper.selectList(queryWrapper));
    }

    //让管理器已选择的菜单自动选中,获取id
    @GetMapping("/ids")
    public Result findAllIds() {
        return Result.success(menuService.list().stream().map(Menu::getId));
    }
}

