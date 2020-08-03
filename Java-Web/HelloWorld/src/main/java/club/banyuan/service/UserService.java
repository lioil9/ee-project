package club.banyuan.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface UserService {
    String getCurrentYear();
    String getBirthYearByAge(int age);
}
