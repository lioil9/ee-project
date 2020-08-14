package club.banyuan.utils;

import java.util.Calendar;

public class DateUtil {

    public static int getCurrentYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
}
