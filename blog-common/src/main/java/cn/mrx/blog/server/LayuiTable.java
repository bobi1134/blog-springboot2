package cn.mrx.blog.server;

import lombok.Data;

/**
 * Author：Mr.X
 * Date：2017/10/13 23:15
 * Description：layui.table返回的数据,共4个,必填
 */
@Data
public class LayuiTable {

    /** 状态值 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 总条数 */
    private Long count;

    /** 数据 */
    private Object data;

    public LayuiTable(Long count, Object data) {
        this.code = 0;
        this.msg = "查询成功";
        this.count = count;
        this.data = data;
    }
}
