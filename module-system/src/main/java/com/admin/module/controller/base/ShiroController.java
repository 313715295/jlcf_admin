package com.admin.module.controller.base;

import com.admin.commons.base.BaseController;
import com.admin.module.entity.User;
import com.admin.module.service.*;
import com.admin.module.shiro.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统模块使用
 */
public class ShiroController extends BaseController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected MenuService menuService;

    @Autowired
    protected RoleService roleService;

    @Autowired
    protected DictService dictService;

    @Autowired
    protected RescourceService rescourceService;

    @Autowired
    protected TableService tableService;

    @Autowired
    protected SiteService siteService;

    @Autowired
    protected LogService logService;

    @Autowired
    protected BlogArticleService blogArticleService;

    @Autowired
    protected BlogChannelService blogChannelService;

    @Autowired
    protected BlogCommentService blogCommentService;

    @Autowired
    protected BlogTagsService blogTagsService;

    @Autowired
    protected QuartzTaskService quartzTaskService;

    @Autowired
    protected QuartzTaskLogService quartzTaskLogService;

    @Autowired
    protected UploadInfoService uploadInfoService;

    User getCurrentUser() {
        MyRealm.ShiroUser shiroUser = (MyRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        if(shiroUser == null) {
            return null;
        }
        return userService.getById(shiroUser.getId());
    }
}
