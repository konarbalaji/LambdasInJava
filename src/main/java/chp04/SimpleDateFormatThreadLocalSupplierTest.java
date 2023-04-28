package chp04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Thread local using Supplier
public class SimpleDateFormatThreadLocalSupplierTest {

    public final static ThreadLocal<DateFormat> formatter = ThreadLocal
                                                            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        String date = "2020-09-09";

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable task = () -> {
            try {
                parseDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        };

        for(int i=0; i<10; i++){
            executorService.submit(task);
        }

        executorService.shutdown();
    }

    private static void parseDate(String date) throws ParseException {
        Date d = formatter.get().parse(date);
        System.out.println("Print with Thread : " + Thread.currentThread() + " : " + d);
    }
}