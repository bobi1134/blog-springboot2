package cn.mrx.blog.enums;

import lombok.Getter;

/**
 * Author：Mr.X
 * Date：2017/11/4 22:29
 * Description：
 */
@Getter
public enum UserStatus {

    NORMAL(0, "启用"),
    STOP(1, "停用");

    private Integer code;
    private String message;

    UserStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
