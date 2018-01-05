package cn.mrx.blog.service.busi.impl;

import cn.mrx.blog.dto.busi.Article;
import cn.mrx.blog.dto.busi.Category;
import cn.mrx.blog.repo.busi.CategoryRepository;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.service.busi.CategoryService;
import cn.mrx.blog.vo.pc.busi.ArticleDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/16 上午9:21
 * Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
