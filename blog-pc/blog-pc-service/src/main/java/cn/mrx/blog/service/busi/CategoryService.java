package cn.mrx.blog.service.busi;

import cn.mrx.blog.dto.busi.Category;
import cn.mrx.blog.vo.pc.busi.ArticleDetailsVo;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/16 上午9:21
 * Description:
 */
public interface CategoryService {

    List<Category> findAll();
}
