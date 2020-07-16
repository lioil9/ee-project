package club.banyuan.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Tool {
  public void addBefore(){
    System.out.println("add---Before");
  }

  public void addAfter(){
    System.out.println("add---after");
  }

  public Object addAround(ProceedingJoinPoint pjp){
    Object rtValue = null;
    try{
      Object[] args = pjp.getArgs();
      addBefore();
      rtValue = pjp.proceed(args);
      addAfter();
    }catch (Throwable e){
      e.printStackTrace();
    }
    return rtValue;
  }

}
