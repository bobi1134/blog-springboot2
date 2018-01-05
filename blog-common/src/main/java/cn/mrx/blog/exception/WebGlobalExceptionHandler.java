package cn.mrx.blog.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Author：Mr.X
 * Date：2017/11/11 9:59
 * Description：全局异常处理类
 */
@ControllerAdvice(basePackages = "cn.mrx.blog.controller.web")
public class WebGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, BlogException e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.setViewName("web/error");
        return mav;
    }
}
