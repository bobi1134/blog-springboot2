package cn.mrx.blog.controller.busi;

import cn.mrx.blog.dto.busi.Article;
import cn.mrx.blog.dto.busi.Category;
import cn.mrx.blog.dto.busi.Link;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.service.busi.ArticleService;
import cn.mrx.blog.service.busi.CategoryService;
import cn.mrx.blog.service.busi.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/15 下午8:44
 * Description:
 */
@Controller
@RequestMapping("/cat")
public class CategoryController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LinkService linkService;

    @GetMapping("/{id}")
    public String category(@PathVariable Integer id, Model model) {
        // todo 分类文章list

        // 所有分类
        List<Category> categoryList = categoryService.findAll();
        // 近期文章
        List<Article> recentArticleList = articleService.findArticle(true, "createTime", null, null);
        // 阅读排行榜文章
        List<Article> readRankArticleList = articleService.findArticle(true, "readSize", null, null);
        // 友情链接
        List<Link> linkList = linkService.findAll();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("readRankArticleList", readRankArticleList);
        model.addAttribute("recentArticleList", recentArticleList);
        model.addAttribute("linkList", linkList);
        return "category";
    }

    @GetMapping("/all")
    @ResponseBody
    public ServerResponse<List<Category>> findAll(){
        return null;
    }
}
