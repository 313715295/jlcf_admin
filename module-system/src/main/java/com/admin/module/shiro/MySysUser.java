package com.admin.module.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * Created by wangl on 2017/11/25.
 * todo:
 */
public class MySysUser {
    /**
     * 取出Shiro中的当前用户LoginName.
     */
    public static String icon() {
        return ShiroUser().getIcon();
    }

    public static Long id() {
        return ShiroUser().getId();
    }

    public static String loginName() {
        return ShiroUser().getloginName();
    }

    public static String nickName(){
        return ShiroUser().getNickName();
    }

    public static MyRealm.ShiroUser ShiroUser() {
        Subject subject = SecurityUtils.getSubject();
        MyRealm.ShiroUser shiroUser = (MyRealm.ShiroUser) subject.getPrincipal();
        return shiroUser;
    }
}
