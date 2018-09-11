package com.admin.module.entity;


import com.admin.module.entity.Base.DataEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客标签
 * </p>
 *
 * @author wangl
 * @since 2018-01-17
 */
@TableName("blog_tags")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class BlogTags extends DataEntity<BlogTags> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签名字
     */
	private String name;
    /**
     * 排序
     */
	private Integer sort;

	@TableField(exist = false)
	private Integer tagsUseCount;

	@Override
	public String toString() {
		return "BlogTags{" +
			", name=" + name +
			", sort=" + sort +
			", tagsUseCount=" + tagsUseCount +
			"}";
	}
}
