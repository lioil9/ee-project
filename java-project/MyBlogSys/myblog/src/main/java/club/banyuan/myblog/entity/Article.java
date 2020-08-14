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
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章所属用户id
     */
    private Long userid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章摘要
     */
    private String description;

    /**
     * 文章正文
     */
    private String context;

    /**
     * 文章创建时间
     */
    private LocalDateTime createtime;

    /**
     * 文章状态,是否被删除, 0,1表示
     */
    private Integer status;


}
