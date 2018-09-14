package com.admin.module.controller.base;

import com.admin.commons.base.BaseController;
import com.admin.module.service.BorrowService;
import com.admin.module.service.IUserService;
import com.admin.module.service.SystemDictService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务模块使用
 */
public class ServiceController extends BaseController {

    @Autowired
    protected SystemDictService systemDictService;

    @Autowired
    protected BorrowService borrowService;

    @Autowired
    protected IUserService iUserService;
}
