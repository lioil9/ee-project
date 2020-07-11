package club.banyuan.util;

import java.lang.reflect.Constructor;
import javax.servlet.http.HttpServletRequest;

public class FilterDataUtil {
  /**
   * 判断请求得到的值是否为空，并且对要得到参数指定类型返回，
   * 将getParameter方法得到的字符串值进行指定类型自动转换
   * @param request
   * @param s
   * @param type
   * @param <T>
   * @return
   */
  public static <T> T isNull(HttpServletRequest request, String s, Class<T> type) {
    T result = null;
    if (request.getParameter(s) == null || request.getParameter(s).isBlank()) {
      return result;
    }
    try {
      Constructor<T> constructor = type.getConstructor(String.class);
      constructor.setAccessible(true);
      result = constructor.newInstance(request.getParameter(s));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

}
