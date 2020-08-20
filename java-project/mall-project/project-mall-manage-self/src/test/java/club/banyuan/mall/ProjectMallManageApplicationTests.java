package club.banyuan.mall;

import club.banyuan.mall.entity.OrderEntity;
import club.banyuan.mall.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ProjectMallManageApplicationTests {

  @Autowired private OrderMapper orderMapper;

  @Test
  void contextLoads() {
    Long[] ids = {1L, 2L};
    List<OrderEntity> orderEntities = orderMapper.selectByPrimaryKeys(ids);
    System.out.println(orderEntities);
  }
}
