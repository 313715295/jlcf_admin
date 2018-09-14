package com.admin.module.service.impl;

import com.admin.module.entity.Account;
import com.admin.module.dao.AccountDao;
import com.admin.module.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

}
