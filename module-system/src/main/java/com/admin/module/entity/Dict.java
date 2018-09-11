package com.admin.module.entity;



import com.admin.module.entity.Base.DataEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * <p>
 * 字典表
 * </p>
 *
 * @author wangl
 * @since 2017-11-26
 */
@TableName("sys_dict")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Dict extends DataEntity<Dict> {

    private static final long serialVersionUID = 1L;

    /**
     * 数据值
     */
	private String value;
    /**
     * 标签名
     */
	private String label;
    /**
     * 类型
     */
	private String type;
    /**
     * 描述
     */
	private String description;
    /**
     * 排序（升序）
     */
	private Integer sort;
    /**
     * 父级编号
     */
	@TableField("parent_id")
	private String parentId;


	@Override
	public String toString() {
		return "Dict{" +
			", value=" + value +
			", label=" + label +
			", type=" + type +
			", description=" + description +
			", sort=" + sort +
			", parentId=" + parentId +
			"}";
	}
}
