package cn.mrx.blog.repo.busi;

import cn.mrx.blog.dto.busi.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author: Mr.X
 * Date: 2017/12/16 上午9:23
 * Description:
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category>{

}
