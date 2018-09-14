package com.admin.module.service.impl;

import com.admin.module.entity.System;
import com.admin.module.dao.SystemDao;
import com.admin.module.service.SystemService;
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
public class SystemServiceImpl extends ServiceImpl<SystemDao, System> implements SystemService {

}
