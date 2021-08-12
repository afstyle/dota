package com.huanghao.interceptor;

import com.huanghao.constant.CookieConstant;
import com.huanghao.pojo.BUser;
import com.huanghao.service.BUserService;
import com.huanghao.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HuangHao
 * @date 2021/8/12 18:01
 */
public class BAuthInterceptor implements HandlerInterceptor {

    @Resource
    private BUserService bUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtil.getCookieValue(request, CookieConstant.B_USER_LOGIN_TOKEN);
        BUser user = bUserService.getBUserByToken(token);
        if (StringUtils.isBlank(token) || null == user) {
            // 返回false
            return false;
        }
        // 把用户信息放入Request
//        request.setAttribute("user", user);
        // 返回值决定handler是否执行。true：执行，false：不执行。
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
