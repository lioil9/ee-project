package club.banyuan.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//通过注解方式获取bean对象
@Component
//用于改变bean的作用范围，默认为单例模式，prototype为原型模式，每次获取bean都会产生一个新的对象
@Scope("prototype")
public class Entity {

//通过EL表达式注解指定properties赋值
  @Value("${str}")
  private String str;

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }
}
