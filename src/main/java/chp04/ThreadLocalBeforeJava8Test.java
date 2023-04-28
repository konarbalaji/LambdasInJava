package chp04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ThreadLocalBeforeJava8Test {
}


class ThreadLocalBeforejava8{

    private static final ThreadLocal<DateFormat> dateFormatter = new ThreadLocal<DateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static DateFormat get(){
        return dateFormatter.get();
    }


}