package club.banyuan.myblog.service.impl;

import club.banyuan.myblog.entity.User;
import club.banyuan.myblog.mapper.UserMapper;
import club.banyuan.myblog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lioil
 * @since 2020-08-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
