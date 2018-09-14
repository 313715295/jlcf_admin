package com.admin.module.controller;


import com.admin.commons.base.Result;
import com.admin.commons.utils.DateUtils;
import com.admin.commons.utils.IpTools;
import com.admin.module.controller.base.ServiceController;
import com.admin.module.entity.Borrow;
import com.admin.module.entity.IUser;
import com.admin.module.entity.SystemDict;
import com.admin.module.util.CheckParmUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoleilu.hutool.date.DateUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.admin.commons.base.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Controller
@RequestMapping("/borrow")
public class BorrowController extends ServiceController {


    @GetMapping("addBorrow")
    @RequiresPermissions("service:borrow:add")
    public String addBorrow(Model model) {
        List<SystemDict> borrowType = systemDictService.listByType("borrowType");
        List<SystemDict> borrowGroup = systemDictService.listByType("borrowGroup");
        List<SystemDict> blaList = systemDictService.listByType("borrowLowestAccount");
        List<SystemDict> bmaList = systemDictService.listByType("borrowMostAccount");
        List<SystemDict> bvtList = systemDictService.listByType("borrowValidTime");
        List<SystemDict> brlList = systemDictService.listByType("borrowValidTime");

        model.addAttribute("borrowType", borrowType);
        model.addAttribute("borrowGroup", borrowGroup);
        model.addAttribute("blaList", blaList);
        model.addAttribute("bmaList", bmaList);
        model.addAttribute("bvtList", bvtList);
        model.addAttribute("brlList", brlList);

        return "/borrow/addBorrow";
    }
    @PostMapping("addBorrow")
    @ResponseBody
    @RequiresPermissions("service:borrow:add")
    public Result addBorrow(Borrow borrow, HttpServletRequest request) {
        boolean check = CheckParmUtil.checkAddBorrow(borrow);
        if (!check) {
            return Result.errorMsg("发标失败:参数异常");
        }
        String userName = borrow.getUserName();
        IUser user = iUserService.getByName(userName);
        if (user == null) {
            return Result.errorMsg("借款人不存在");
        }
        borrow.setUserId(user.getUserId())
                .setAccountYes(new BigDecimal(0))
                .setAddip(IpTools.gainRealIp(request))
                .setAddtime(DateUtils.getNowTimeStr())
        ;
        Borrow saveBorrow = borrowService.ISave(borrow);
        if (saveBorrow == null) {
            return Result.errorMsg("发标失败");
        }
        return Result.successMsg("发标成功");
    }
}

