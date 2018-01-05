package cn.mrx.blog.dto.busi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author: Mr.X
 * Date: 2017/12/18 下午6:53
 * Description:
 */
@Data
@Entity
@Table(name = "busi_remark")
public class Remark {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    private Date createTime;

    private Integer articleId;

    private Integer userId;

    private Integer isRead;

    private Integer parentId;
}
