package cn.mrx.blog.interceptor;

import cn.mrx.blog.dto.busi.User;
import cn.mrx.blog.server.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author: Mr.X
 * Date: 2017/12/18 上午11:13
 * Description:
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        log.info("过滤url请求:{}", url);
        // 判断是否有@NeddLogin注解
        HandlerMethod methodHandler = (HandlerMethod) handler;
        if (methodHandler.getMethodAnnotation(NeedLogin.class) != null) {
            log.info("url请求:{}需要登录后才能访问", url);
            // 判断该用户是否已经登录
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Const.PC_CURRENT_USER);
            if (user != null) {
                log.info("用户[{}]已登录,可以访问", user.getUsername());
                return true;
            }
            log.info("用户未登录,不可以访问,正在重定向到登录页面");
            // 用户登录成功后应该跳转回此路径
            session.setAttribute(Const.REDIRECT_URL, url);
            response.sendRedirect("/login");
            return false;
        }
        log.info("{}请求不用登录,可直接访问", url);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
