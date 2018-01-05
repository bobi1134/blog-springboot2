package cn.mrx.blog.dto.busi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Mr.X
 * Date: 2017/12/16 上午9:12
 * Description:
 */
@Data
@Entity
@Table(name = "busi_category")
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer isTop;
}
