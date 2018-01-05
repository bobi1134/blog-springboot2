package cn.mrx.blog.service.busi.impl;

import cn.mrx.blog.dto.busi.Article;
import cn.mrx.blog.dto.busi.Category;
import cn.mrx.blog.dto.busi.Remark;
import cn.mrx.blog.dto.busi.User;
import cn.mrx.blog.repo.busi.ArticleRepository;
import cn.mrx.blog.repo.busi.CategoryRepository;
import cn.mrx.blog.repo.busi.UserRepository;
import cn.mrx.blog.server.Const;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.service.busi.ArticleService;
import cn.mrx.blog.util.MarkdownUtil;
import cn.mrx.blog.util.TimeAxisUtil;
import cn.mrx.blog.vo.pc.busi.ArticleDetailsVo;
import cn.mrx.blog.vo.pc.busi.ArticleListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午6:04
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ArticleListVo> findRecommendArticle(Pageable pageable) {
        List<ArticleListVo> vos = new ArrayList<>();
        List<Article> articleList = articleRepository.findByIsRecommend(Const.ArticleIsRecommend.RECOMMENDED.getCode(), pageable);
        for (Article article : articleList) {
            ArticleListVo vo = new ArticleListVo();
            vo.setId(article.getId());
            vo.setTitle(article.getTitle());
            vo.setSummary(article.getSummary());
            vo.setReadSize(article.getReadSize());
            vo.setLikeSize(article.getLikeSize());
            vo.setTimeAxis(TimeAxisUtil.timeFormatText(article.getCreateTime()));
            Category category = categoryRepository.findOne(article.getCategoryId());
            vo.setCategoryName(category.getName());
            User user = userRepository.findOne(article.getUserId());
            vo.setAuthor(user.getUsername());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public ArticleDetailsVo findArticleDetails(Integer articleId) {
        ArticleDetailsVo articleDetailsVo = new ArticleDetailsVo();
        Article article = articleRepository.findOne(articleId);
        articleDetailsVo.setId(article.getId());
        articleDetailsVo.setTitle(article.getTitle());
        articleDetailsVo.setContent(MarkdownUtil.mdToHtml(article.getContent()));
        articleDetailsVo.setReadSize(article.getReadSize());
        articleDetailsVo.setLikeSize(article.getLikeSize());
        articleDetailsVo.setTimeAxis(TimeAxisUtil.timeFormatText(article.getCreateTime()));
        Category category = categoryRepository.findOne(article.getCategoryId());
        articleDetailsVo.setCategoryName(category.getName());
        User user = userRepository.findOne(article.getUserId());
        articleDetailsVo.setAuthor(user.getUsername());
        articleDetailsVo.setEmail(user.getEmail());
        articleDetailsVo.setUserId(user.getId());
        return articleDetailsVo;
    }

    @Override
    public List<Article> findArticle(Boolean isFromAllData, String sortName, Integer id, Integer articleFindIdType) {
        if (isFromAllData) {
            // 1 从全部数据中查询
            Sort sort = new Sort(Sort.Direction.DESC, sortName);
            Pageable pageable = new PageRequest(0, Const.RECENT_OR_READRANK_OR_REMARK_SIZE, sort);
            Page<Article> articlePage = articleRepository.findAll(pageable);
            return articlePage.getContent();
        } else {
            // 2 指定用户进行查询
            int userId = 0;
            // 2.1 根据articleId查询到userId
            if (Const.ArticleFindIdType.ARTICLE_ID.getCode() == articleFindIdType) {
                Article article = articleRepository.findOne(id);
                userId = article.getUserId();
            } else if (Const.ArticleFindIdType.USER_ID.getCode() == articleFindIdType) {
                userId = id;
            }
            Sort sort = new Sort(Sort.Direction.DESC, sortName);
            Pageable pageable = new PageRequest(0, Const.RECENT_OR_READRANK_OR_REMARK_SIZE, sort);
            return articleRepository.findAllByUserId(userId, pageable);
        }
    }

    @Override
    public List<ArticleListVo> findAll(Integer userId, Pageable pageable) {
        Page<Article> articlePage = articleRepository.findAll(pageable);
        List<Article> articleList = articlePage.getContent();
        // 转换为Vo
        List<ArticleListVo> vos = new ArrayList<>();
        for (Article article : articleList) {
            ArticleListVo vo = new ArticleListVo();
            vo.setId(article.getId());
            vo.setTitle(article.getTitle());
            vo.setSummary(article.getSummary());
            vo.setReadSize(article.getReadSize());
            vo.setLikeSize(article.getLikeSize());
            vo.setTimeAxis(TimeAxisUtil.timeFormatText(article.getCreateTime()));
            Category category = categoryRepository.findOne(article.getCategoryId());
            vo.setCategoryName(category.getName());
            User user = userRepository.findOne(article.getUserId());
            vo.setAuthor(user.getUsername());
            vos.add(vo);
        }
        return vos;
    }
}
