package chp04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatThreadTest {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        String date = "2020-09-09";

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable task = () -> parseDate(date);

        for(int i=0;i<10;i++){
            executorService.submit(task);
        }

        executorService.shutdown();
    }

    private static void parseDate(String dateToParse) {

        try{
            Date date = simpleDateFormat.parse(dateToParse);
            System.out.println("Successfully Parsed Date : using Thread " +  Thread.currentThread() + date);
        }catch(ParseException e){
            System.out.println("ParseError " + e.getMessage());
        }
    }
}
