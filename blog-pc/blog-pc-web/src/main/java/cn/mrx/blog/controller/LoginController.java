package cn.mrx.blog.controller;

import cn.mrx.blog.server.Const;
import cn.mrx.blog.server.ServerResponse;
import cn.mrx.blog.service.busi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午2:56
 * Description:
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ServerResponse login(String username, String password, HttpSession session) {
        ServerResponse serverResponse = userService.login(username, password);
        if (serverResponse.isSuccess()) {
            session.setAttribute(Const.PC_CURRENT_USER, serverResponse.getData());
        }
        return serverResponse;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
