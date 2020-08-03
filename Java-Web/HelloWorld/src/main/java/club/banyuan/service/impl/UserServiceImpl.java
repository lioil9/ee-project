package club.banyuan.service.impl;

import club.banyuan.service.UserService;
import club.utils.DateUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getCurrentYear() {
        int year = DateUtil.getCurrentYear();
        return String.valueOf(year);
    }

    @Override
    public String getBirthYearByAge(int age) {
        int birthYear = DateUtil.getCurrentYear() - age;
        return String.valueOf(birthYear);
    }
}
