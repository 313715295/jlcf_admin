package com.admin.module.service.impl;

import com.admin.module.dao.IUserDao;
import com.admin.module.entity.IUser;
import com.admin.module.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "IUser")
public class IUserServiceImpl extends ServiceImpl<IUserDao, IUser> implements IUserService {


    @Override
    @Cacheable(key = "#userName")
    public IUser getByName(String userName) {
        QueryWrapper<IUser> queryWrapper = new QueryWrapper<IUser>().eq("username", userName);
        return baseMapper.selectOne(queryWrapper);
    }
}
