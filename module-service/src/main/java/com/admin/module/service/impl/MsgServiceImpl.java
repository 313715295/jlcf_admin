package com.admin.module.service.impl;

import com.admin.module.entity.Msg;
import com.admin.module.dao.MsgDao;
import com.admin.module.service.MsgService;
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
public class MsgServiceImpl extends ServiceImpl<MsgDao, Msg> implements MsgService {

}
