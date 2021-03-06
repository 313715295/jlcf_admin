package com.admin.module.entity;

import com.admin.module.entity.Base.DataEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangl
 * @since 2017-10-31
 */
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class User extends DataEntity<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
	@TableField("login_name")
	private String loginName;
    /**
     * 昵称
     */
	@TableField(value = "nick_name",strategy= FieldStrategy.IGNORED)
	private String nickName;
    /**
     * 密码
     */
	private String password;
    /**
     * shiro加密盐
     */
	private String salt;
    /**
     * 手机号码
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String tel;
    /**
     * 邮箱地址
     */
	@TableField(strategy= FieldStrategy.IGNORED)
	private String email;
	
	/**
	 * 账户是否锁定
	 */
	private Boolean locked;

	@TableField(strategy= FieldStrategy.IGNORED)
	private String icon;

	@TableField(exist=false)
	private Set<Role> roleLists = Sets.newHashSet();
	
	@TableField(exist=false)
	private Set<Menu> menus = Sets.newHashSet();

}
