package lambdas.chp04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalBeforeJava8Test {

    public static void main(String[] args) {
        String date = "2020-09-09";

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable task = () -> parseDate(date);

        for(int i=0; i<10 ; i++){
            System.out.println("calling parse using thread : " + Thread.currentThread());
            executorService.submit(() -> parseDate(date));
        }

        executorService.shutdown();
    }


    public static void parseDate(String dateToParse){
        try{

            Date date = ThreadLocalBeforeJava8.get().parse(dateToParse);
            System.out.println("Successfully Parsed Date using " +  Thread.currentThread() +  " : " + date);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadLocalBeforeJava8{

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