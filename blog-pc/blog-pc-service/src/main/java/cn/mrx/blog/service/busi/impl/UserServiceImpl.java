package cn.mrx.blog.service.busi.impl;

import cn.mrx.blog.dto.busi.User;
import cn.mrx.blog.repo.busi.UserRepository;
import cn.mrx.blog.server.ResponseCode;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.service.busi.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午4:21
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ServerResponse login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ServerResponse.error(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return ServerResponse.error(ResponseCode.NOT_FOUND.getCode(), "用户名或密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.success("登录成功", user);
    }
}
