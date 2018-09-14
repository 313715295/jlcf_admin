package com.admin.module.service;

import com.admin.module.entity.SystemDict;
import com.admin.commons.base.BaseService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
public interface SystemDictService extends BaseService<SystemDict> {


    List<SystemDict> listByType(String type,String orderType,String... orderColumns);
    List<SystemDict> listByType(String type);
}
