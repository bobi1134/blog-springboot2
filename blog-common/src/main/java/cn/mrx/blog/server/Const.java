package cn.mrx.blog.server;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author：Mr.X
 * Date：2017/10/23 20:10
 * Description：
 */
public class Const {

    // pc端登录用户
    public static final String PC_CURRENT_USER = "pc_current_user";
    // pc端用户登录成功后跳转路径
    public static final String REDIRECT_URL = "redirect_url";
    // 近期文章|阅读排行榜|评论排行榜显示数量
    public static final Integer RECENT_OR_READRANK_OR_REMARK_SIZE = 10;

    @Getter
    @AllArgsConstructor
    public enum ArticleIsRecommend {
        RECOMMENDED(0, "推荐文章"),
        NOT_RECOMMENDED(1, "非推荐文章");
        private int code;
        private String msg;
    }

    @Getter
    @AllArgsConstructor
    public enum ArticleFindIdType {
        ARTICLE_ID(0, "文章ID"),
        USER_ID(1, "文章ID");
        private int code;
        private String msg;
    }

    @Getter
    @AllArgsConstructor
    public enum ArticleIsRead {
        UNREAD(0, "未读"),
        READ(1, "已读");
        private int code;
        private String msg;
    }
}
