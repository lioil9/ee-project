package club.banyuan.myblog.dto;

import club.banyuan.myblog.entity.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

}
