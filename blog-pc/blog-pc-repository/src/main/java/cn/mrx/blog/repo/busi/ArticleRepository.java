package cn.mrx.blog.repo.busi;

import cn.mrx.blog.dto.busi.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午7:08
 * Description:
 */
public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {

    // 首页-推荐文章 todo 需要分页询
    List<Article> findByIsRecommend(Integer isRecommend, Pageable pageable);

    // 用户自己的最新文章|阅读排行文章,只取前10条数据
    List<Article> findAllByUserId(Integer userId, Pageable pageable);
}
