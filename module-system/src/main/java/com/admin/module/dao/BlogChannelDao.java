package com.admin.module.dao;


import com.admin.module.entity.BlogChannel;
import com.admin.module.entity.VO.ZtreeVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客栏目 Mapper 接口
 * </p>
 *
 * @author wangl
 * @since 2018-01-17
 */
public interface BlogChannelDao extends BaseMapper<BlogChannel> {

    List<ZtreeVO> selectZtreeData(Map<String, Object> map);

    List<BlogChannel> selectChannelData(Map<String, Object> map);
}
