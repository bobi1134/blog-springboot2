package cn.mrx.blog.service.busi.impl;

import cn.mrx.blog.dto.busi.Link;
import cn.mrx.blog.repo.busi.LinkRepository;
import cn.mrx.blog.service.busi.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/17 上午8:36
 * Description:
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public List<Link> findAll() {
        return linkRepository.findAll();
    }
}
