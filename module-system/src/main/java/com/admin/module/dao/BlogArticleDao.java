package com.admin.module.dao;


import com.admin.module.entity.BlogArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客内容 Mapper 接口
 * </p>
 *
 * @author wangl
 * @since 2018-01-17
 */
public interface BlogArticleDao extends BaseMapper<BlogArticle> {

    List<BlogArticle> selectIndexArticle(Map<String, Object> map);

    List<BlogArticle> selectDetailArticle(Map<String, Object> map, Page<BlogArticle> page);

    List<BlogArticle> selectDetailArticle(Map<String, Object> map);

    List<BlogArticle> selectNewCommentArticle(Integer limit);

    /**
     * 查找当前文章的标签相似的文章
     * @param map
     * @return
     */
    List<BlogArticle> selectLikeSameWithTags(Map<String, Object> map);

    void saveArticleTags(Map<String, Object> map);

    void removeArticleTags(Long articleId);
}
