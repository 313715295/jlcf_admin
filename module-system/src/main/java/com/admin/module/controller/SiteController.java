package com.admin.module.controller;



import com.admin.commons.annotation.SysLog;
import com.admin.module.controller.base.ShiroController;

import com.admin.module.entity.Site;
import com.admin.module.entity.UploadInfo;
import com.admin.module.entity.VO.SiteVO;
import com.admin.module.service.UploadService;
import com.admin.commons.utils.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2017-12-30
 */
@Controller
@RequestMapping("/admin/system/site")
public class SiteController extends ShiroController{




    @RequiresPermissions("sys:site:list")
    @GetMapping("show")
    @SysLog("跳转网站展示页面")
    public String show(Model model){
        Site site = siteService.getCurrentSite();
        SiteVO siteVO = new SiteVO();
        BeanUtils.copyProperties(site,siteVO);
        model.addAttribute("site",siteVO);
        return "admin/system/site/show";
    }


    @RequiresPermissions("sys:site:edit")
    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存网站基本数据")
    public RestResponse edit(Site site,HttpServletRequest httpServletRequest){
        if(site.getId() == null){
            return RestResponse.failure("ID不能为空");
        }
        if(site.getId() != 1){
            return RestResponse.failure("ID不正确");
        }
        if(StringUtils.isBlank(site.getName())){
            return RestResponse.failure("站点名称不能为空");
        }
        if(StringUtils.isNotBlank(site.getRemarks())){
            site.setRemarks(site.getRemarks().replace("\"", "\'"));
        }
        siteService.updateSite(site);
        return RestResponse.success();
    }
}
