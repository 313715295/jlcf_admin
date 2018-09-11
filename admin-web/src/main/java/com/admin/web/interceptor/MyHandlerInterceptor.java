package com.admin.web.interceptor;

import com.admin.module.entity.Site;
import com.admin.module.entity.User;
import com.admin.module.entity.VO.SiteVO;
import com.admin.module.service.SiteService;
import com.admin.module.service.UserService;
import com.admin.module.shiro.MySysUser;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangl on 2017/11/30.
 * todo:
 */
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MyHandlerInterceptor.class);

    @Autowired
    private SiteService siteService;
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
//        LOGGER.info("当前请求路径.."+httpServletRequest.getRequestURI());
        if (siteService == null || userService == null) {//解决service为null无法注入问题
            System.out.println("siteService is null!!!");
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());
            siteService = (SiteService) factory.getBean("siteService");
            userService = (UserService) factory.getBean("userService");

        }
        Site site = siteService.getCurrentSite();
        SiteVO siteVO = new SiteVO();
        BeanUtils.copyProperties(site,siteVO);
        httpServletRequest.setAttribute("site",siteVO);
        User user = userService.findUserById(MySysUser.id());
        if(user != null){
            httpServletRequest.setAttribute("currentUser",user);
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
