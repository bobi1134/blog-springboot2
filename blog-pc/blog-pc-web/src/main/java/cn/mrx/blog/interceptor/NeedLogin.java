package cn.mrx.blog.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Mr.X
 * Date: 2017/12/18 上午11:25
 * Description:
 */
@Retention(RetentionPolicy.RUNTIME) //声明元注解
@Target({ElementType.METHOD}) //在方法上生效
public @interface NeedLogin {
}
