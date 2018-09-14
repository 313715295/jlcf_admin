package com.admin.module.service;

import com.admin.module.entity.Borrow;
import com.admin.commons.base.BaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
public interface BorrowService extends BaseService<Borrow> {

    Borrow ISave(Borrow borrow);
}
