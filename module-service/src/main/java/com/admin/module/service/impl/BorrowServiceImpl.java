package com.admin.module.service.impl;

import com.admin.module.entity.Borrow;
import com.admin.module.dao.BorrowDao;
import com.admin.module.service.BorrowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
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
@CacheConfig(cacheNames = "borrow")
@Slf4j
public class BorrowServiceImpl extends ServiceImpl<BorrowDao, Borrow> implements BorrowService {

    @Override
    @CachePut(key = "#result.id",condition = "#result!= null")
    public Borrow ISave(Borrow borrow) {
        try {
            baseMapper.insert(borrow);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("发布标的失败");
            return null;
        }
        log.info("发布标的成功：{}",borrow);
        return borrow;
    }
}
