package com.admin.module.controller;


import com.admin.commons.annotation.SysLog;
import com.admin.module.entity.QuartzTaskLog;
import com.admin.module.service.QuartzTaskLogService;
import com.admin.module.utils.LayerData;
import com.admin.commons.utils.RestResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * <p>
 * 任务执行日志  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-01-25
 */
@Controller
@RequestMapping("/admin/quartzTaskLog")
public class QuartzTaskLogController {

    @Autowired
    private QuartzTaskLogService quartzTaskLogService;

    @GetMapping("list")
    @SysLog("跳转任务执行日志列表")
    public String list(){
        return "/admin/quartzTaskLog/list";
    }

    @RequiresPermissions("quartz:log:list")
    @PostMapping("list")
    @ResponseBody
    public LayerData<QuartzTaskLog> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                         @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                         ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<QuartzTaskLog> layerData = new LayerData<>();
        QueryWrapper<QuartzTaskLog> wrapper = new QueryWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String name = (String) map.get("name");
            if(StringUtils.isNotBlank(name)) {
                wrapper.like("name",name);
            }else{
                map.remove("name");
            }

        }
        IPage<QuartzTaskLog> pageData = quartzTaskLogService.page(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount((int) pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    public String add(){
        return "/admin/quartzTaskLog/add";
    }

    @PostMapping("add")
    @ResponseBody
    public RestResponse add(QuartzTaskLog quartzTaskLog){
        quartzTaskLogService.save(quartzTaskLog);
        return RestResponse.success();
    }

    @GetMapping("edit")
    public String edit(Long id,Model model){
        QuartzTaskLog quartzTaskLog = quartzTaskLogService.getById(id);
        model.addAttribute("quartzTaskLog",quartzTaskLog);
        return "/admin/quartzTaskLog/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    public RestResponse edit(QuartzTaskLog quartzTaskLog){
        if(null == quartzTaskLog.getId() || 0 == quartzTaskLog.getId()){
            return RestResponse.failure("ID不能为空");
        }
        quartzTaskLogService.updateById(quartzTaskLog);
        return RestResponse.success();
    }

    @RequiresPermissions("quartz:log:delete")
    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除任务执行日志数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        QuartzTaskLog quartzTaskLog = quartzTaskLogService.getById(id);
        quartzTaskLog.setDelFlag(true);
        quartzTaskLogService.updateById(quartzTaskLog);
        return RestResponse.success();
    }

}