package cn.mrx.blog.controller;

import cn.mrx.blog.dto.busi.Article;
import cn.mrx.blog.dto.busi.Category;
import cn.mrx.blog.dto.busi.Link;
import cn.mrx.blog.server.Const;
import cn.mrx.blog.service.busi.ArticleService;
import cn.mrx.blog.service.busi.CategoryService;
import cn.mrx.blog.service.busi.LinkService;
import cn.mrx.blog.vo.pc.busi.ArticleListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/13 下午5:16
 * Description:
 */
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private LinkService linkService;

    @GetMapping
    public String index(Model model) {
        //推荐文章 todo 这里需要分页
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(0, 10, sort);
        List<ArticleListVo> recommendArticleList = articleService.findRecommendArticle(pageable);

        // 所有分类
        List<Category> categoryList = categoryService.findAll();
        // 近期文章
        List<Article> recentArticleList = articleService.findArticle(true, "createTime", null, null);
        // 阅读排行榜文章
        List<Article> readRankArticleList = articleService.findArticle(true, "readSize", null, null);
        // 友情链接
        List<Link> linkList = linkService.findAll();

        model.addAttribute("recommendArticleList", recommendArticleList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("readRankArticleList", readRankArticleList);
        model.addAttribute("recentArticleList", recentArticleList);
        model.addAttribute("linkList", linkList);
        return "index";
    }

    @GetMapping("/404")
    public String pageNotFound() {
        return "404";
    }
}
