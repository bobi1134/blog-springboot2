package cn.mrx.blog.vo.pc.busi;

import lombok.Data;

/**
 * Author: Mr.X
 * Date: 2017/12/18 下午7:06
 * Description:
 */
@Data
public class RemarkListVo {
    // 本表数据
    private Integer id;
    private String content;
    private String timeAxis;
    private Integer parentId;

    // 他表数据
    private String author;
    private String replyTo; //@xxx
}
