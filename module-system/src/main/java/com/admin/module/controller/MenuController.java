package com.admin.module.controller;

import com.admin.commons.annotation.SysLog;
import com.admin.module.controller.base.ShiroController;
import com.admin.module.entity.Menu;
import com.admin.module.entity.VO.ZtreeVO;
import com.admin.commons.utils.RestResponse;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by wangl on 2017/12/3.
 * todo:
 */
@Controller
@RequestMapping("/admin/system/menu")
@Slf4j
public class MenuController extends ShiroController {

    @GetMapping("list")
    @SysLog("跳转菜单列表")
    public String list(Model model) {
        return "admin/system/menu/test";
    }

    @RequiresPermissions("sys:menu:list")
    @PostMapping("tree")
    @ResponseBody
    public RestResponse tree() {
        List<ZtreeVO> ztreeVOs = menuService.showTreeMenus();
       log.info(JSONObject.toJSONString(ztreeVOs));
        return RestResponse.success().setData(ztreeVOs);
    }

    @RequiresPermissions("sys:menu:list")
    @PostMapping("treelist")
    @ResponseBody
    public RestResponse treelist() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("parentId", null);
        map.put("isShow", false);
        return RestResponse.success().setData(menuService.selectAllMenus(map));
    }

    @GetMapping("add")
    public String add(@RequestParam(value = "parentId", required = false) Long parentId, Model model) {
        if (parentId != null) {
            Menu menu = menuService.getById(parentId);
            model.addAttribute("parentMenu", menu);
        }
        return "admin/system/menu/add";
    }

    @RequiresPermissions("sys:menu:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存新增菜单数据")
    public RestResponse add(Menu menu) {
        if (StringUtils.isBlank(menu.getName())) {
            return RestResponse.failure("菜单名称不能为空");
        }
        if (menuService.getCountByName(menu.getName()) > 0) {
            return RestResponse.failure("菜单名称已存在");
        }
        if (StringUtils.isNotBlank(menu.getPermission())) {
            if (menuService.getCountByPermission(menu.getPermission()) > 0) {
                return RestResponse.failure("权限标识已经存在");
            }
        }
        if (menu.getParentId() == null) {
            menu.setLevel(1);
            Object o = menuService.getObj(new QueryWrapper<Menu>().select("max(sort)").isNull("parent_id"));
            int sort = 0;
            if (o != null) {
                sort = (Integer) o + 10;
            }
            menu.setSort(sort);
        } else {
            Menu parentMenu = menuService.getById(menu.getParentId());
            if (parentMenu == null) {
                return RestResponse.failure("父菜单不存在");
            }
            menu.setParentIds(parentMenu.getParentIds());
            menu.setLevel(parentMenu.getLevel() + 1);
            Object o = menuService.getObj(new QueryWrapper<Menu>()
                    .select("max(sort)")
                    .eq("parent_id", menu.getParentId()));
            int sort = 0;
            if (o != null) {
                sort = (Integer) o + 10;
            }
            menu.setSort(sort);
        }
        menuService.saveOrUpdateMenu(menu);
        menu.setParentIds(StringUtils.isBlank(menu.getParentIds()) ? menu.getId() + "," : menu.getParentIds() + menu.getId() + ",");
        menuService.saveOrUpdateMenu(menu);
        return RestResponse.success();
    }

    @GetMapping("edit")
    public String edit(Long id, Model model) {
        Menu menu = menuService.getById(id);
        model.addAttribute("menu", menu);
        return "admin/system/menu/edit";
    }

    @RequiresPermissions("sys:menu:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑菜单数据")
    public RestResponse edit(Menu menu) {
        if (menu.getId() == null) {
            return RestResponse.failure("菜单ID不能为空");
        }
        if (StringUtils.isBlank(menu.getName())) {
            return RestResponse.failure("菜单名称不能为空");
        }
        Menu oldMenu = menuService.getById(menu.getId());
        if (!oldMenu.getName().equals(menu.getName())) {
            if (menuService.getCountByName(menu.getName()) > 0) {
                return RestResponse.failure("菜单名称已存在");
            }
        }
        if (StringUtils.isNotBlank(menu.getPermission())) {
            if (!oldMenu.getPermission().equals(menu.getPermission())) {
                if (menuService.getCountByPermission(menu.getPermission()) > 0) {
                    return RestResponse.failure("权限标识已经存在");
                }
            }
        }
        if (menu.getSort() == null) {
            return RestResponse.failure("排序值不能为空");
        }
        menuService.saveOrUpdateMenu(menu);
        return RestResponse.success();
    }

    @RequiresPermissions("sys:menu:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除菜单")
    public RestResponse delete(@RequestParam(value = "id", required = false) Long id) {
        if (id == null) {
            return RestResponse.failure("菜单ID不能为空");
        }
        Menu menu = menuService.getById(id);
        menu.setDelFlag(true);
        menuService.saveOrUpdateMenu(menu);
        return RestResponse.success();
    }

    @PostMapping("isShow")
    @ResponseBody
    public RestResponse isShow(@RequestParam(value = "id", required = false) Long id,
                               @RequestParam(value = "isShow", required = false) String isShow) {
        if (id == null) {
            return RestResponse.failure("菜单ID不能为空");
        }
        if (isShow == null) {
            return RestResponse.failure("设置参数不能为空");
        } else {
            if (!"true".equals(isShow) && !"false".equals(isShow)) {
                return RestResponse.failure("设置参数不正确");
            }
        }
        Boolean showFalg = Boolean.valueOf(isShow);
        Menu menu = menuService.getById(id);
        menu.setIsShow(showFalg);
        menuService.saveOrUpdateMenu(menu);
        return RestResponse.success();

    }

}
