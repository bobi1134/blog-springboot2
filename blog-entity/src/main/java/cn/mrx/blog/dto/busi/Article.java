package cn.mrx.blog.dto.busi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午6:04
 * Description:
 */
@Data
@Entity
@Table(name = "busi_article")
public class Article {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String summary;

    private String content;

    private Integer readSize;

    private Integer likeSize;

    private Integer isRecommend;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer categoryId;

    private Integer userId;
}
