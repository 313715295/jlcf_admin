package com.admin.module.entity;

import com.admin.module.entity.Base.DataEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangl
 * @since 2017-10-31
 */
@TableName("sys_role")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Role extends DataEntity<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
	private String name;

	@TableField(exist = false)
	private Set<Menu> menuSet;

	@TableField(exist = false)
	private Set<User> userSet;

}
