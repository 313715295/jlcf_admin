package com.admin.module.service.impl;

import com.admin.module.entity.AccountLog;
import com.admin.module.dao.AccountLogDao;
import com.admin.module.service.AccountLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资金记录 服务实现类
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Service
public class AccountLogServiceImpl extends ServiceImpl<AccountLogDao, AccountLog> implements AccountLogService {

}
