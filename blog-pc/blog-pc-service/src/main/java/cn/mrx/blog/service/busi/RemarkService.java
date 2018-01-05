package cn.mrx.blog.service.busi;

import cn.mrx.blog.dto.busi.Remark;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.vo.pc.busi.RemarkListVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Author: Mr.X
 * Date: 2017/12/18 下午7:43
 * Description:
 */
public interface RemarkService {

    List<RemarkListVo> findAll(Integer articleId, Pageable pageable);

    // 添加评论
    ServerResponse add(Remark remark);
}
