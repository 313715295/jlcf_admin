package com.admin.module.service;

import com.admin.module.entity.IUser;
import com.admin.commons.base.BaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
public interface IUserService extends BaseService<IUser> {

    IUser getByName(String userName);
}
