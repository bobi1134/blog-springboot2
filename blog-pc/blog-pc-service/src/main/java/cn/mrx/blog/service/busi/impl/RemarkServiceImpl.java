package cn.mrx.blog.service.busi.impl;

import cn.mrx.blog.dto.busi.Remark;
import cn.mrx.blog.dto.busi.User;
import cn.mrx.blog.repo.busi.RemarkRepository;
import cn.mrx.blog.repo.busi.UserRepository;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.service.busi.RemarkService;
import cn.mrx.blog.util.TimeAxisUtil;
import cn.mrx.blog.vo.pc.busi.RemarkListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/18 下午7:44
 * Description:
 */
@Service
public class RemarkServiceImpl implements RemarkService {

    @Autowired
    private RemarkRepository remarkRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<RemarkListVo> findAll(Integer articleId, Pageable pageable) {
        List<RemarkListVo> vos = new ArrayList<>();
        Page<Remark> remarkPage = remarkRepository.findAllByArticleId(articleId, pageable);
        List<Remark> remarkList = remarkPage.getContent();
        for (Remark remark : remarkList) {
            RemarkListVo vo = new RemarkListVo();
            vo.setId(remark.getId());
            vo.setContent(remark.getContent());
            vo.setParentId(remark.getParentId());
            vo.setTimeAxis(TimeAxisUtil.timeFormatText(remark.getCreateTime()));
            // aa@bb
            // aa
            User user = userRepository.findOne(remark.getUserId());
            vo.setAuthor(user.getUsername());
            if (vo.getParentId() != null) {
                // bb
                remark = remarkRepository.findOne(remark.getParentId());
                user = userRepository.findOne(remark.getUserId());
                vo.setReplyTo(user.getUsername());
            }
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public ServerResponse add(Remark remark) {
        Remark dbRemark = remarkRepository.save(remark);
        if (dbRemark != null) {
            return ServerResponse.success("评论成功");
        }
        return ServerResponse.error("评论失败");
    }
}
