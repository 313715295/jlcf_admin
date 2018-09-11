package com.admin.module.controller;


import com.admin.commons.annotation.SysLog;
import com.admin.module.controller.base.ShiroController;
import com.admin.module.entity.Rescource;
import com.admin.module.utils.LayerData;
import com.admin.module.utils.QiniuFileUtil;
import com.admin.commons.utils.RestResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by wangl on 2018/1/14.
 * todo:
 */
@Controller
@RequestMapping("/admin/system/rescource")
public class RescourceController extends ShiroController{

    @GetMapping("list")
    @SysLog("跳转资源展示列表")
    public String list(){
        return "admin/system/rescource/list";
    }

    @RequiresPermissions("sys:rescource:list")
    @PostMapping("list")
    @ResponseBody
    public LayerData<Rescource> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                     ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<Rescource> layerData = new LayerData<>();
        QueryWrapper<Rescource> wrapper = new QueryWrapper<>();
        if(!map.isEmpty()){
            String type = (String) map.get("type");
            if(StringUtils.isNotBlank(type)) {
                wrapper.like("file_type", type);
            }
            String hash = (String)map.get("hash");
            if(StringUtils.isNotBlank(hash)){
                wrapper.eq("hash",hash);
            }
            String source = (String)map.get("source");
            if(StringUtils.isNotBlank(source)){
                wrapper.eq("source",source);
            }
        }
        IPage<Rescource> dataPage = rescourceService.page(new Page<>(page,limit),wrapper);
        layerData.setCount((int) dataPage.getTotal());
        layerData.setData(dataPage.getRecords());
        return layerData;
    }

    @RequiresPermissions("sys:rescource:delete")
    @PostMapping("delete")
    @SysLog("删除系统资源")
    @ResponseBody
    public RestResponse delete(@RequestParam("ids[]") List<Long> ids){
        if(ids == null || ids.size() == 0){
            return RestResponse.failure("删除ID不能为空");
        }
        List<Rescource> rescources = (List<Rescource>) rescourceService.listByIds(ids);
        if(rescources == null || rescources.size()==0){
            return RestResponse.failure("请求参数不正确");
        }
        for (Rescource rescource : rescources){
            QiniuFileUtil.deleteQiniuP(rescource.getWebUrl());
        }
        rescourceService.removeByIds(ids);
        return RestResponse.success();
    }

    @GetMapping("test")
    @SysLog("测试错误请求")
    public String error() throws Exception {
        throw new Exception("测试异常消息");
    }
}
