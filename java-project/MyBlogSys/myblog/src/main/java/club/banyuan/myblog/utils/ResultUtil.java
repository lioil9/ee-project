package club.banyuan.myblog.utils;

import club.banyuan.myblog.dto.Result;

public class ResultUtil {

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
