package cn.mrx.blog.repo.busi;

import cn.mrx.blog.dto.busi.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Author: Mr.X
 * Date: 2017/12/16 下午4:22
 * Description:
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    
    User findByUsernameAndPassword(String username, String password);
}
