package cn.mrx.blog.controller.busi;

import cn.mrx.blog.dto.busi.Article;
import cn.mrx.blog.dto.busi.Category;
import cn.mrx.blog.dto.busi.User;
import cn.mrx.blog.interceptor.NeedLogin;
import cn.mrx.blog.server.Const;
import cn.mrx.blog.service.busi.ArticleService;
import cn.mrx.blog.service.busi.CategoryService;
import cn.mrx.blog.vo.pc.busi.ArticleListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/15 下午8:46
 * Description:
 */
@Controller
@RequestMapping("/u")
public class UserController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public String user(@PathVariable Integer id, Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "u";
    }

    @NeedLogin
    @GetMapping("/me")
    public String me(Model model, @RequestParam(defaultValue = "createTime") String sortName, HttpSession session) {
        // 所有文章,按发布时间(默认)|阅读量|评论量进行分野查询
        User user = (User) session.getAttribute(Const.PC_CURRENT_USER);
        Sort sort = new Sort(Sort.Direction.DESC, sortName);
        Pageable pageable = new PageRequest(0, 10, sort);
        List<ArticleListVo> articleList= articleService.findAll(user.getId(), pageable);
        // 所有分类
        List<Category> categoryList = categoryService.findAll();
        //近期文章
        List<Article> recentArticleList = articleService.findArticle(false, "createTime", user.getId(), Const.ArticleFindIdType.USER_ID.getCode());
        //阅读排行榜文章
        List<Article> readRankArticleList = articleService.findArticle(false, "readSize", user.getId(), Const.ArticleFindIdType.USER_ID.getCode());

        model.addAttribute("articleList", articleList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("readRankArticleList", readRankArticleList);
        model.addAttribute("recentArticleList", recentArticleList);
        return "u";
    }
}
