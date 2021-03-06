package com.admin.module.controller;


import com.admin.commons.annotation.SysLog;
import com.admin.module.controller.base.ShiroController;

import com.admin.module.entity.Menu;
import com.admin.module.entity.Role;
import com.admin.module.entity.User;
import com.admin.commons.utils.LayerData;
import com.admin.commons.utils.RestResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangl on 2017/12/2.
 * todo:
 */
@Controller
@RequestMapping("admin/system/role")
public class RoleController extends ShiroController{

    @GetMapping("list")
    @SysLog("跳转角色列表页面")
    public String list(){
        return "admin/system/role/list";
    }

    @RequiresPermissions("sys:role:list")
    @PostMapping("list")
    @ResponseBody
    public LayerData<Role> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<Role> roleLayerData = new LayerData<>();
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String keys = (String) map.get("key");
            if(StringUtils.isNotBlank(keys)) {
                roleQueryWrapper.like("name", keys);
            }
        }
        IPage<Role> rolePage = roleService.page(new Page<>(page,limit),roleQueryWrapper);
        roleLayerData.setCount((int) rolePage.getTotal());
        roleLayerData.setData(setUserToRole(rolePage.getRecords()));
        return roleLayerData;
    }

    private List<Role> setUserToRole(List<Role> roles){
        for(Role r : roles){
            if(r.getCreateId() != null && r.getCreateId() != 0){
                User u = userService.findUserById(r.getCreateId());
                if(StringUtils.isBlank(u.getNickName())){
                    u.setNickName(u.getLoginName());
                }
                r.setCreateUser(u);
            }
            if(r.getUpdateId() != null && r.getUpdateId() != 0){
                User u  = userService.findUserById(r.getUpdateId());
                if(StringUtils.isBlank(u.getNickName())){
                    u.setNickName(u.getLoginName());
                }
                r.setUpdateUser(u);
            }
        }
        return roles;
    }

    @GetMapping("add")
    public String add(Model model){
        Map<String,Object> map = Maps.newHashMap();
        map.put("parentId",null);
        map.put("isShow",false);
        List<Menu> menuList = menuService.selectAllMenus(map);
        model.addAttribute("menuList",menuList);
        return "admin/system/role/add";
    }

    @RequiresPermissions("sys:role:add")
    @PostMapping("add")
    @ResponseBody
    @SysLog("保存新增角色数据")
    public RestResponse add(@RequestBody Role role){
        if(StringUtils.isBlank(role.getName())){
            return RestResponse.failure("角色名称不能为空");
        }
        if(roleService.getRoleNameCount(role.getName())>0){
            return RestResponse.failure("角色名称已存在");
        }
        roleService.saveRole(role);
        return RestResponse.success();
    }

    @GetMapping("edit")
    public String edit(Long id,Model model){
        Role role = roleService.getRoleById(id);
        StringBuilder menuIds = new StringBuilder();
        if(role != null) {
            Set<Menu> menuSet = role.getMenuSet();
            if (menuSet != null && menuSet.size() > 0) {
                for (Menu m : menuSet) {
                    menuIds.append(m.getId().toString()).append(",");
                }
            }
        }
        Map<String,Object> map = Maps.newHashMap();
        map.put("parentId",null);
        map.put("isShow",false);
        List<Menu> menuList = menuService.selectAllMenus(map);
        model.addAttribute("role",role);
        model.addAttribute("menuList",menuList);
        model.addAttribute("menuIds",menuIds.toString());
        return "admin/system/role/edit";
    }

    @RequiresPermissions("sys:role:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑角色数据")
    public RestResponse edit(@RequestBody Role role){
        if(role.getId() == null || role.getId() == 0){
            return RestResponse.failure("角色ID不能为空");
        }
        if(StringUtils.isBlank(role.getName())){
            return RestResponse.failure("角色名称不能为空");
        }
        Role oldRole = roleService.getRoleById(role.getId());
        if(!oldRole.getName().equals(role.getName())){
            if(roleService.getRoleNameCount(role.getName())>0){
                return RestResponse.failure("角色名称已存在");
            }
        }
        roleService.updateRole(role);
        return RestResponse.success();
    }

    @RequiresPermissions("sys:role:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除角色数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(id == null || id == 0){
            return RestResponse.failure("角色ID不能为空");
        }
        Role role = roleService.getRoleById(id);
        roleService.deleteRole(role);
        return RestResponse.success();
    }

    @RequiresPermissions("sys:role:delete")
    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("多选删除角色数据")
    public RestResponse deleteSome(@RequestBody List<Role> roles){
        if(roles == null || roles.size()==0){
            return RestResponse.failure("请选择需要删除的角色");
        }
        for (Role r : roles){
            roleService.deleteRole(r);
        }
        return RestResponse.success();
    }


}
