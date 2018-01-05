package cn.mrx.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author：Mr.X
 * Date：2017/11/6 10:49
 * Description：
 */
@Getter
@AllArgsConstructor
public enum ArticleStatus {

    UP_SHELVES(0, "上架"),
    DOWN_SHELVES(1, "下架"),
    DRAFT(2, "草稿");

    private Integer code;
    private String message;
}
