package cn.mrx.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: Mr.X
 * Date: 2017/12/13 下午5:25
 * Description:
 */
@Controller
@RequestMapping("/admin")
public class HelloController {

    @GetMapping
    @ResponseBody
    public Object index(){
        return "hello admin";
    }
}
