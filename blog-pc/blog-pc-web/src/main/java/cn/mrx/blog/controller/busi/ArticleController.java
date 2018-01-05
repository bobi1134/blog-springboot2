package cn.mrx.blog.controller.busi;

import cn.mrx.blog.dto.busi.*;
import cn.mrx.blog.interceptor.NeedLogin;
import cn.mrx.blog.server.Const;
import cn.mrx.blog.service.busi.ArticleService;
import cn.mrx.blog.service.busi.CategoryService;
import cn.mrx.blog.service.busi.LinkService;
import cn.mrx.blog.service.busi.RemarkService;
import cn.mrx.blog.vo.pc.busi.ArticleDetailsVo;
import cn.mrx.blog.vo.pc.busi.RemarkListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/15 下午8:39
 * Description:
 */
@Controller
@RequestMapping("/p")
public class ArticleController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private RemarkService remarkService;

    @GetMapping("/{id}")
    public String article(@PathVariable Integer id, Model model) {
        // 所有分类
        List<Category> categoryList = categoryService.findAll();
        // 友情链接
        List<Link> linkList = linkService.findAll();
        // 近期文章
        List<Article> recentArticleList = articleService.findArticle(false, "createTime", id, Const.ArticleFindIdType.ARTICLE_ID.getCode());
        // 阅读排行榜文章
        List<Article> readRankArticleList = articleService.findArticle(false, "readSize", id, Const.ArticleFindIdType.ARTICLE_ID.getCode());
        // 文章详情
        ArticleDetailsVo articleDetails = articleService.findArticleDetails(id);
        // 所有评论 todo 需要分页
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(0, 10, sort);
        List<RemarkListVo> remarkList = remarkService.findAll(id, pageable);

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("recentArticleList", recentArticleList);
        model.addAttribute("readRankArticleList", readRankArticleList);
        model.addAttribute("linkList", linkList);
        model.addAttribute("articleDetails", articleDetails);
        model.addAttribute("remarkList", remarkList);
        return "article";
    }

    @NeedLogin
    @GetMapping("/add")
    public String add(Model model, HttpSession session){
        // 所有分类
        List<Category> categoryList = categoryService.findAll();
        // 友情链接
        List<Link> linkList = linkService.findAll();
        User user = (User) session.getAttribute(Const.PC_CURRENT_USER);
        // 近期文章
        List<Article> recentArticleList = articleService.findArticle(false, "createTime", user.getId(), Const.ArticleFindIdType.USER_ID.getCode());
        // 阅读排行榜文章
        List<Article> readRankArticleList = articleService.findArticle(false, "readSize", user.getId(), Const.ArticleFindIdType.USER_ID.getCode());

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("linkList", linkList);
        model.addAttribute("recentArticleList", recentArticleList);
        model.addAttribute("readRankArticleList", readRankArticleList);
        return "article-add";
    }
}
