package cn.mrx.blog.repo.busi;

import cn.mrx.blog.dto.busi.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author: Mr.X
 * Date: 2017/12/17 上午8:37
 * Description:
 */
public interface LinkRepository extends JpaRepository<Link, Integer>, JpaSpecificationExecutor<Link> {
}
