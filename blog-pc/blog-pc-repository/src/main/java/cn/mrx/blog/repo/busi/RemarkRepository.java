package cn.mrx.blog.repo.busi;

import cn.mrx.blog.dto.busi.Remark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author: Mr.X
 * Date: 2017/12/18 下午7:47
 * Description:
 */
public interface RemarkRepository extends JpaRepository<Remark, Integer>, JpaSpecificationExecutor<Remark> {

    Page<Remark> findAllByArticleId(Integer articleId, Pageable pageable);
}
