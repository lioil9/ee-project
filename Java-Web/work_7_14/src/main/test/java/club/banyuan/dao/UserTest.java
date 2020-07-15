package club.banyuan.dao;

import club.banyuan.entity.CollectionEntity;
import club.banyuan.entity.Entity;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

  @Test
  public void testInit(){
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    User user = (User) ctx.getBean("user");
    CollectionEntity collectionEntity = (CollectionEntity) ctx.getBean("collectionEntity");
    User user1 = ctx.getBean(User.class);
    System.out.println(user);
    System.out.println(collectionEntity.getList());


    System.out.println(user1);
    Entity entity = ctx.getBean(Entity.class);
    System.out.println(entity.getStr());

    UserService userService = ctx.getBean(UserService.class);
    userService.add(user);
  }

}
