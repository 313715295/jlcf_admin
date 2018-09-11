package com.admin.module.entity;


import com.admin.module.entity.Base.TreeEntity;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangl
 * @since 2017-10-31
 */
@TableName("sys_menu")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Menu extends TreeEntity<Menu> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String icon;
	/**
     * 链接地址
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String href;
    /**
     * 打开方式
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String target;
    /**
     * 是否显示
     */
	@TableField(value="is_show",strategy= FieldStrategy.IGNORED)
	private Boolean isShow;

	@TableField("bg_color")
	private String bgColor;
    /**
     * 权限标识
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String permission;

	@TableField(exist = false)
	private Integer dataCount;


	@Length(min = 0, max = 1000, message = "icon长度必须介于 1 和 1000 之间")
	public String getIcon() {
		return icon;
	}


}
