package club.banyuan.handler;

import club.banyuan.dto.Result;
import club.banyuan.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 定义全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result<?> handler(Exception e){
        if(e instanceof MethodArgumentNotValidException){
            StringBuffer sb = new StringBuffer();
            for (FieldError error : ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors()) {
                sb.append(error.getField()).append(":").append(error.getDefaultMessage()).append("\n");
            }
            return ResultUtil.error(-1, sb.toString());
        }
        log.error("系统异常",e);
        return ResultUtil.error(-1, e.getMessage());
    }
}
