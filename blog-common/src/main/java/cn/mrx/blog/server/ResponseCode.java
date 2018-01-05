package cn.mrx.blog.server;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author：Mr.X
 * Date：2017/10/23 17:49
 * Description：
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(0, "成功"),
    ERROR(1, "失败"),
    NEED_LOGIN(2, "需要登录"),
    ILLEGAL_ARGUMENT(3, "参数错误"),
    NOT_FOUND(4, "未找到该记录");

    private final int code;
    private final String desc;
}
