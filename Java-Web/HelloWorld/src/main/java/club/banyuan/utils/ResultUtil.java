package club.banyuan.utils;

import club.banyuan.dto.Result;

public class ResultUtil {

    public static Result<?> success(Object object){
        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result<?> success(){
        return success(null);
    }

    public static Result<?> error(Integer code, String msg){
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

