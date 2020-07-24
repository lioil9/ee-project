package club.banyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "club.banyuan.mapper")
public class ShoppingstreetBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShoppingstreetBootApplication.class, args);
  }

}
