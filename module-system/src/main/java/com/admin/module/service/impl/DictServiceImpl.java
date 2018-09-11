package com.admin.module.service.impl;


import com.admin.module.dao.DictDao;
import com.admin.module.entity.Dict;
import com.admin.module.service.DictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2017-11-26
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl extends ServiceImpl<DictDao, Dict> implements DictService {

    @Cacheable(value = "dictCache",key = "#type",unless = "#result == null or #result.size() == 0")
    @Override
    public List<Dict> getDictByType(String type) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        wrapper.eq("del_flag",false);
        wrapper.orderByAsc("sort");
        return list(wrapper);
    }

    @Override
    public Integer getCountByType(String type) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        wrapper.eq("del_flag",false);
        return count(wrapper);
    }

    @Override
    public Integer getMaxSortByType(String type) {
        Object o = getObj(new QueryWrapper<Dict>().select("max(sort)").eq("type",type));
        int sort = 0;
        if(o != null){
            sort =  (Integer)o + 1;
        }
        return sort;
    }

    @Override
    public Integer getCountByAll(String type, String label, String value) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        if(StringUtils.isNotBlank(label)){
            wrapper.eq("label",label);
        }
        if(StringUtils.isNotBlank(value)){
            wrapper.eq("value",value);
        }
        wrapper.eq("del_flag",false);
        return count(wrapper);
    }

    @CacheEvict(value = "dictCache",key = "#dict.type",condition = "#dict.type ne null ")
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void saveOrUpdateDict(Dict dict) {
        saveOrUpdate(dict);
    }

    @CacheEvict(value = "dictCache",key = "#result",beforeInvocation = false,condition = "#result ne  null ")
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public String deleteDict(Long id) {
        Dict dict = baseMapper.selectById(id);
        baseMapper.deleteById(id);
        return dict.getType();
    }

    @CacheEvict(value = "dictCache",key = "#type",beforeInvocation = false)
    @Override
    public List<Dict> saveDictList(String type, List<Dict> list) {
        saveBatch(list);
        return list;
    }

    @CacheEvict(value = "dictCache",key = "#type",beforeInvocation = false)
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteByType(String type) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        remove(wrapper);
    }

    @CacheEvict(value = "dictCache",allEntries=true)
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteByTableName(String tableName) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.like("description","数据表【"+tableName+"】");
        remove(wrapper);
    }

    @CacheEvict(value = "dictCache",allEntries=true)
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void updateByType(String oldType,String newType) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("type",oldType);
        List<Dict> dicts = baseMapper.selectList(wrapper);
        for (Dict dict : dicts){
            dict.setType(newType);
        }
        updateBatchById(dicts);
    }
}
