package com.admin.module.entity;


import com.admin.module.entity.Base.DataEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统资源
 * </p>
 *
 * @author wangl
 * @since 2018-01-14
 */
@TableName("sys_rescource")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Rescource extends DataEntity<Rescource> {

    private static final long serialVersionUID = 1L;

    /**
     * 文件名称
     */
	@TableField("file_name")
	private String fileName;
    /**
     * 来源
     */
	private String source;
    /**
     * 资源网络地址
     */
	@TableField("web_url")
	private String webUrl;
    /**
     * 文件标识
     */
	private String hash;
    /**
     * 文件大小
     */
	@TableField("file_size")
	private String fileSize;
    /**
     * 文件类型
     */
	@TableField("file_type")
	private String fileType;

	@TableField("original_net_url")
	private String originalNetUrl;


	@Override
	public String toString() {
		return "Rescource{" +
			", fileName=" + fileName +
			", source=" + source +
			", webUrl=" + webUrl +
			", hash=" + hash +
			", fileSize=" + fileSize +
			", fileType=" + fileType +
			", originalNetUrl=" + originalNetUrl +
			"}";
	}
}
