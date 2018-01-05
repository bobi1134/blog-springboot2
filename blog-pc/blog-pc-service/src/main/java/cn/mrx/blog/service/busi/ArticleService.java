package cn.mrx.blog.service.busi;

import cn.mrx.blog.dto.busi.Article;
import cn.mrx.blog.dto.busi.Remark;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.vo.pc.busi.ArticleDetailsVo;
import cn.mrx.blog.vo.pc.busi.ArticleListVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午6:04
 * Description:
 */
public interface ArticleService {

    // 推荐文章列表 todo 需要分页询
    List<ArticleListVo> findRecommendArticle(Pageable pageable);

    // 文章详情
    ArticleDetailsVo findArticleDetails(Integer articleId);

    // 近期文章|阅读排行榜
    List<Article> findArticle(Boolean isFromAllData, String sortName, Integer id, Integer articleFindIdType);

    // todo 需要需改
    List<ArticleListVo> findAll(Integer userId, Pageable pageable);
}
