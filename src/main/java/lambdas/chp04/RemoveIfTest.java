package lambdas.chp04;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveIfTest {

    public static void main(String[] args) {

        List<CachedItem> cachedItems = getCachedItem();

        //Using for loop
        usingForLoop(cachedItems);

        //usingItertor
        usingItertor(cachedItems);

        //UsingLambdas
        usingLambdas(cachedItems);

    }

    private static void usingLambdas(List<CachedItem> cachedItems) {
        System.out.println("========== using lambdas ========= ");
        cachedItems.removeIf(item -> item.getDuration().compareTo(Duration.ofSeconds(50))>0);
        cachedItems.forEach(System.out::println);
    }

    private static void usingItertor(List<CachedItem> cachedItems) {
        System.out.println("========== using Iterator ========= ");
        Iterator<CachedItem> iter = cachedItems.iterator();

        while(iter.hasNext()){
            CachedItem item = iter.next();
            if(isStale(item)){
                iter.remove();
            }
        }

        cachedItems.forEach(System.out::println);
    }

    private static void usingForLoop(List<CachedItem> cachedItems){
        System.out.println("========== using For Loop ========= ");

        for(CachedItem item : cachedItems){
            if(isStale(item)){
                cachedItems.remove(item);
            }
        }

        cachedItems.forEach(System.out::println);
    }

    private static boolean isStale(CachedItem cachedItem){
        return cachedItem.getDuration().compareTo(Duration.ofSeconds(50)) > 0;
    }

    private static List<CachedItem> getCachedItem(){

        List<CachedItem> items = new ArrayList<>();

        items.add(new CachedItem("AAPL", Duration.ofSeconds(30)));
        items.add(new CachedItem("AMZN", Duration.ofSeconds(40)));
        items.add(new CachedItem("MSFT", Duration.ofSeconds(50)));
        items.add(new CachedItem("GOOGL", Duration.ofSeconds(60)));
        items.add(new CachedItem("NFLX", Duration.ofSeconds(90)));

        return items;
    }

}
