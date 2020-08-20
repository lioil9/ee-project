package club.banyuan.mall.exception;

import org.springframework.security.core.AuthenticationException;

public class VerifyCodeException extends AuthenticationException {
    public VerifyCodeException(String msg){
        super(msg);
    }
}
