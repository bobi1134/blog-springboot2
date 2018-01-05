package cn.mrx.blog.dto.busi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午4:19
 * Description:
 */
@Data
@Entity
@Table(name = "busi_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Integer status;

    private Date createTime;
}
