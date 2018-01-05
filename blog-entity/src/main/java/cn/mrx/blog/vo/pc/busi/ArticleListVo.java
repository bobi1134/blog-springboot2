package cn.mrx.blog.vo.pc.busi;

import lombok.Data;

/**
 * Author: Mr.X
 * Date: 2017/12/17 上午8:53
 * Description:
 */
@Data
public class ArticleListVo {
    // 本表数据
    private Integer id;
    private String title;
    private String summary;
    private Integer readSize;
    private Integer likeSize;
    private String timeAxis;

    // 他表数据
    private String categoryName;
    private String author;
    private Integer remarkSize;
}
