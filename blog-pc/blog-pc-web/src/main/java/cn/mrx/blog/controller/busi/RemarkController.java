package cn.mrx.blog.controller.busi;

import cn.mrx.blog.dto.busi.Remark;
import cn.mrx.blog.dto.busi.User;
import cn.mrx.blog.server.Const;
import cn.mrx.blog.server.ResponseCode;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.service.busi.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Author: Mr.X
 * Date: 2017/12/18 下午10:24
 * Description:
 */
@Controller
@RequestMapping("/remark")
public class RemarkController {

    @Autowired
    private RemarkService remarkService;

    @PostMapping("/add")
    @ResponseBody
    public ServerResponse remark(Integer articleId, String content, Integer parentId, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute(Const.PC_CURRENT_USER);
        if (user != null) {
            Remark remark = new Remark();
            remark.setContent(content);
            remark.setCreateTime(new Date());
            remark.setArticleId(articleId);
            remark.setUserId(user.getId());
            remark.setParentId(parentId);
            return remarkService.add(remark);
        }
        // 用户登录成功后跳转路径
        session.setAttribute(Const.REDIRECT_URL, request.getHeader("Referer"));
        return ServerResponse.error(ResponseCode.NEED_LOGIN.getCode(), "用户未登录");
    }
}
