package cn.mrx.blog.enums;

import lombok.Getter;

/**
 * Author：Mr.X
 * Date：2017/11/9 16:46
 * Description：
 */
@Getter
public enum CategoryLevel {

    P_ID(0, "父分类");

    private Integer code;
    private String message;

    CategoryLevel(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
