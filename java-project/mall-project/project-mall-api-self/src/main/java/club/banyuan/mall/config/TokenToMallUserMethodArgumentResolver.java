package club.banyuan.mall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import club.banyuan.mall.common.MyException;
import club.banyuan.mall.common.ServiceResultEnum;
import club.banyuan.mall.config.annotation.TokenToMallUser;
import club.banyuan.mall.dto.MallUser;
import club.banyuan.mall.dto.MallUserToken;

@Component
public class TokenToMallUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

  //	@Autowired
  //	private MallUserMapper mallUserMapper;
  //	@Autowired
  //	private NewBeeMallUserTokenMapper newBeeMallUserTokenMapper;

  public TokenToMallUserMethodArgumentResolver() {}

  @Override
  public Object resolveArgument(
      MethodParameter parameter,
      ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest,
      WebDataBinderFactory binderFactory) {
    //		if (parameter.getParameterAnnotation(TokenToMallUser.class) instanceof TokenToMallUser) {
    //			MallUser mallUser = null;
    //			String token = webRequest.getHeader("token");
    //			if (null != token && !"".equals(token)) {
    //				MallUserToken mallUserToken = newBeeMallUserTokenMapper.selectByToken(token);
    //				if (mallUserToken == null || mallUserToken.getExpireTime().getTime() <=
    // System.currentTimeMillis()) {
    //					MyException.fail(ServiceResultEnum.TOKEN_EXPIRE_ERROR.getResult());
    //				}
    //				mallUser = mallUserMapper.selectByPrimaryKey(mallUserToken.getUserId());
    //				if (mallUser == null) {
    //					MyException.fail(ServiceResultEnum.USER_NULL_ERROR.getResult());
    //				}
    //				if (mallUser.getLockedFlag().intValue() == 1) {
    //					MyException.fail(ServiceResultEnum.LOGIN_USER_LOCKED_ERROR.getResult());
    //				}
    //				return mallUser;
    //			} else {
    //				MyException.fail(ServiceResultEnum.NOT_LOGIN_ERROR.getResult());
    //			}
    //		}
    return null;
  }

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    if (parameter.hasParameterAnnotation(TokenToMallUser.class)) {
      return true;
    }
    return false;
  }
}
