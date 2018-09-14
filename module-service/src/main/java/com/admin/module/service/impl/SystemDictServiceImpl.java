package com.admin.module.service.impl;

import com.admin.module.entity.SystemDict;
import com.admin.module.dao.SystemDictDao;
import com.admin.module.service.SystemDictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Service
@CacheConfig(cacheNames = "systemDict")
public class SystemDictServiceImpl extends ServiceImpl<SystemDictDao, SystemDict> implements SystemDictService {

    @Cacheable(key = "#type",unless = "#result == null or #result.size() == 0")
    @Override
    public List<SystemDict> listByType(String type,String orderType,String... orderColumns) {
        QueryWrapper<SystemDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type);
        if ("asc".equals(orderType)) {
            queryWrapper.orderByAsc(orderColumns);
        }
        if ("desc".equals(orderType)) {
            queryWrapper.orderByDesc(orderColumns);
        }
        baseMapper.selectList(queryWrapper);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<SystemDict> listByType(String type) {
        return baseMapper.selectList(new QueryWrapper<SystemDict>().eq("type",type).orderByAsc("id"));
    }
}
