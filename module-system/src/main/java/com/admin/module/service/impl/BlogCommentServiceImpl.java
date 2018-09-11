package com.admin.module.service.impl;


import com.admin.module.dao.BlogCommentDao;
import com.admin.module.entity.BlogComment;
import com.admin.module.service.BlogCommentService;
import com.admin.module.utils.Constants;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客评论 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-01-17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentDao, BlogComment> implements BlogCommentService {

    @Override
    public Integer getMaxFloor(Long articleId) {
        Object o = null;
        if(articleId != null){
            o = getObj(new QueryWrapper<BlogComment>().select("max(floor)").eq("article_id",articleId));
        }else{
            o = getObj(new QueryWrapper<BlogComment>().select("max(floor)").eq("type", Constants.COMMENT_TYPE_LEVING_A_MESSAGE));
        }

        Integer floor = 0;
        if(o != null){
            floor =  (Integer)o;
        }
        return floor;
    }

    @Override
    public Integer getMaxFloorByReply(Long replyId) {
        Object o = getObj(new QueryWrapper<BlogComment>().select("max(floor)").eq("reply_id",replyId));
        Integer floor = 0;
        if(o != null){
            floor =  (Integer)o;
        }
        return floor;
    }

    @Override
    public Page<BlogComment> getArticleComments(Long articleId,Integer type,Page<BlogComment> page) {
        Map<String,Object> map = Maps.newHashMap();
        if(articleId != null){
            map.put("articleId",articleId);
        }
        map.put("type",type);
        List<BlogComment> list = baseMapper.selectArticleCommentsByPlus(map,page);
        page.setRecords(list);
        return page;
    }

    @CacheEvict(value = "commentData",key = "'article_'+#blogComment.articleId+'_commentcount'")
    @Override
    public void saveOrUpdateBlogComment(BlogComment blogComment) {
        saveOrUpdate(blogComment);
    }

    @Cacheable(value = "commentData",key = "'article_'+#articleId+'_commentcount'")
    @Override
    public Integer getArticleCommentsCount(Long articleId) {
        QueryWrapper<BlogComment> wrapper = new QueryWrapper<>();
        wrapper.eq("del_flag", false);
        wrapper.eq("type", Constants.COMMENT_TYPE_ARTICLE_COMMENT);
        wrapper.eq("article_id", articleId);
        return count(wrapper);
    }
}
