package cn.mrx.blog.service.busi;

import cn.mrx.blog.server.ServerResponse;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午4:21
 * Description:
 */
public interface UserService {

    ServerResponse login(String username, String password);
}
