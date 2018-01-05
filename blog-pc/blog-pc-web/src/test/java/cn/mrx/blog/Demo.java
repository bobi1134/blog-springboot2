package cn.mrx.blog;

import cn.mrx.blog.repo.busi.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: Mr.X
 * Date: 2017/12/13 下午5:12
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        System.out.println(userRepository.findByUsernameAndPassword("mrx", "111111"));
    }
}
