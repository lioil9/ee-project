package club.banyuan.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.Arrays;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    System.out.println(DigestUtils.md5DigestAsHex("lioil".getBytes()));
    System.out.println(DigestUtils.md5DigestAsHex("202cb962ac59075b964b07152d234b70".getBytes()));
    }

}
