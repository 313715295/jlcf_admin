package com.admin.module.service.impl;


import com.admin.module.dao.UserDao;
import com.admin.module.entity.Role;
import com.admin.module.entity.User;
import com.admin.module.service.UserService;
import com.admin.module.utils.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangl
 * @since 2017-10-31
 */
@Service("userService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

	/* 这里caching不能添加put 因为添加了总会执行该方法
	 * @see com.mysiteforme.service.UserService#findUserByLoginName(java.lang.String)
	 */
	@Cacheable(value = "user", key = "'user_name_'+#name",unless = "#result == null")
	@Override
	public User findUserByLoginName(String name) {
//		// TODO Auto-generated method stub
		Map<String,Object> map = Maps.newHashMap();
		map.put("loginName", name);
		return baseMapper.selectUserByMap(map);
	}


	@Cacheable(value = "user",key="'user_id_'+T(String).valueOf(#id)",unless = "#result == null")
	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		Map<String,Object> map = Maps.newHashMap();
		map.put("id", id);
		return baseMapper.selectUserByMap(map);
	}

	@Override
	@Caching(put = {
			@CachePut(value = "user", key = "'user_id_'+T(String).valueOf(#result.id)",condition = "#result.id != null and #result.id != 0"),
			@CachePut(value = "user", key = "'user_name_'+#user.loginName", condition = "#user.loginName !=null and #user.loginName != ''"),
			@CachePut(value = "user", key = "'user_email_'+#user.email", condition = "#user.email != null and #user.email != ''"),
			@CachePut(value = "user", key = "'user_tel_'+#user.tel", condition = "#user.tel != null and #user.tel != ''")
	})
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public User saveUser(User user) {
		ToolUtil.entryptPassword(user);
		user.setLocked(false);
		baseMapper.insert(user);
		return findUserById(user.getId());
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "user", key = "'user_id_'+T(String).valueOf(#user.id)",condition = "#user.id != null and #user.id != 0"),
			@CacheEvict(value = "user", key = "'user_name_'+#user.loginName", condition = "#user.loginName !=null and #user.loginName != ''"),
			@CacheEvict(value = "user", key = "'user_email_'+#user.email", condition = "#user.email != null and #user.email != ''"),
			@CacheEvict(value = "user", key = "'user_tel_'+#user.tel", condition = "#user.tel != null and #user.tel != ''" ),
	})
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public User updateUser(User user) {
		baseMapper.updateById(user);
		return user;
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void saveUserRoles(Long id, Set<Role> roleSet) {
		baseMapper.saveUserRoles(id,roleSet);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void dropUserRolesByUserId(Long id) {
		baseMapper.dropUserRolesByUserId(id);
	}

	@Override
	public int userCount(String param) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("login_name",param).or().eq("email",param).or().eq("tel",param);
		int count = baseMapper.selectCount(wrapper);
		return count;
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	@Caching(evict = {
			@CacheEvict(value = "user", key = "'user_id_'+T(String).valueOf(#user.id)",condition = "#user.id != null and #user.id != 0"),
			@CacheEvict(value = "user", key = "'user_name_'+#user.loginName", condition = "#user.loginName !=null and #user.loginName != ''"),
			@CacheEvict(value = "user", key = "'user_email_'+#user.email", condition = "#user.email != null and #user.email != ''"),
			@CacheEvict(value = "user", key = "'user_tel_'+#user.tel", condition = "#user.tel != null and #user.tel != ''" )
	})
	public void deleteUser(User user) {
		user.setDelFlag(true);
		user.updateById();
	}

	/**
	 * 查询用户拥有的每个菜单具体数量
	 * @return
	 */
	@Override
	public Map selectUserMenuCount() {
		return baseMapper.selectUserMenuCount();
	}

}
