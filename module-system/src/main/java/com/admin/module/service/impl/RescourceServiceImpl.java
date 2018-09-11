package com.admin.module.service.impl;


import com.admin.module.dao.RescourceDao;
import com.admin.module.entity.Rescource;
import com.admin.module.service.RescourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 系统资源 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-01-14
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RescourceServiceImpl extends ServiceImpl<RescourceDao, Rescource> implements RescourceService {

    @Override
    public int getCountByHash(String hash) {
        QueryWrapper<Rescource> wrapper = new QueryWrapper<>();
        wrapper.eq("hash",hash);
        return count(wrapper);
    }

    @Override
    public Rescource getRescourceByHash(String hash) {
        QueryWrapper<Rescource> wrapper = new QueryWrapper<>();
        wrapper.eq("hash",hash);
        return getOne(wrapper);
    }
}
