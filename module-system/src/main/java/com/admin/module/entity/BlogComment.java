package com.admin.module.entity;


import com.admin.module.entity.Base.DataEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 博客评论
 * </p>
 *
 * @author wangl
 * @since 2018-01-18
 */
@TableName("blog_comment")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class BlogComment extends DataEntity<BlogComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论内容
     */
	private String content;

	/**
	 * 评论类型：1.文章评论，2.系统留言
	 */
	private Integer type;
    /**
     * ip
     */
	private String ip;
    /**
     * 操作系统
     */
	private String system;
    /**
     * 浏览器
     */
	private String browser;
    /**
     * 楼层
     */
	private Integer floor;
    /**
     * 栏目ID
     */
	@TableField("channel_id")
	private Long channelId;
    /**
     * 文章ID
     */
	@TableField("article_id")
	private Long articleId;
    /**
     * 回复评论ID
     */
	@TableField("reply_id")
	private Long replyId;
    /**
     * 管理员是否回复
     */
	@TableField("is_admin_reply")
	private Boolean isAdminReply;
    /**
     * 管理员回复内容
     */
	@TableField("reply_content")
	private String replyContent;

	@TableField(exist = false)
	private List<BlogComment> replayList;


	@Override
	public String toString() {
		return "BlogComment{" +
			", content=" + content +
			", ip=" + ip +
			", system=" + system +
			", browser=" + browser +
			", floor=" + floor +
			", channelId=" + channelId +
			", articleId=" + articleId +
			", replyId=" + replyId +
			", isAdminReply=" + isAdminReply +
			", replyContent=" + replyContent +
			"}";
	}
}
