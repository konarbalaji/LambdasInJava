package streams.chp08;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileTests {

    public static void main(String[] args) {

        List<Stock> stocks = getStocks();

        //take while example
        List<String> stocksBelow1000 = getStocksBelowThousand(stocks);
        System.out.println(stocksBelow1000);
    }

    private static List<String> getStocksBelowThousand(List<Stock> stocks){
        return stocks.stream()
                .takeWhile(s -> isStockLessThanThousand(s))
                .map(Stock::getName)
                .collect(Collectors.toList());
    }

    private static boolean isStockLessThanThousand(Stock s) {
        return s.getValue().compareTo(BigDecimal.valueOf(1000)) < 0;
    }

    private static List<Stock> getStocks(){
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("Apple",BigDecimal.valueOf(1000)));
        stocks.add(new Stock("Amazon",BigDecimal.valueOf(800)));
        stocks.add(new Stock("Netflix",BigDecimal.valueOf(2000)));
        stocks.add(new Stock("Facebook",BigDecimal.valueOf(500)));
        stocks.add(new Stock("Instagram",BigDecimal.valueOf(100)));

        return stocks.stream()
                .sorted(Comparator.comparing(Stock::getValue))
                .collect(Collectors.toList());

    }
}