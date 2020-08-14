package club.banyuan.myblog;

import club.banyuan.myblog.entity.User;
import club.banyuan.myblog.mapper.UserMapper;
import club.banyuan.myblog.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;

@SpringBootTest
class MyblogApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService  userService;

    @Test
    void contextLoads() {
//        List<User> userEntities = userService.list();
//        System.out.println(userEntities);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","markerhub");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    public void passwordTest(){
    System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
