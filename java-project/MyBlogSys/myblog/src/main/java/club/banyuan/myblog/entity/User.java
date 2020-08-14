package club.banyuan.myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lioil
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名，登录名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像地址
     */
    private String avatar;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户状态，是否注销
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 最后一次登陆时间
     */
    private LocalDateTime lastLogin;


}
