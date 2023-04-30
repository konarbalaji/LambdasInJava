package lambdas.chp04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exchange {

    //1.Get Symbol of stocks where volume is >= 1 million
    public static List<String> getHighVolumeStocks(List<Trade> trades){

        List<String> stocks = new ArrayList<>();

        for(Trade t : trades){
            if(t.getVolume() >= 1000000){
                stocks.add(t.getStock().getSymbol());
            }
        }

        return stocks;

    }

    //2.Get Symbol of Stock by type of Transactions
    public static List<String> getStocksByTradeType(List<Trade> trades, TradeType tradeType){
        List<String> stocks = new ArrayList<>();

        for(Trade t : trades){
            if(t.getTradeType()==tradeType){
                stocks.add(t.getStock().getSymbol());
            }
        }

        return stocks;
    }

    public static List<String> getStock(List<Trade> trades, Predicate<Trade> tradeFilter, Function<Trade, String> tradeTransformer){

        Objects.requireNonNull(tradeFilter);
        Objects.requireNonNull(tradeTransformer);

        List<String> stocks = new ArrayList<>();

        for(Trade t : trades){
            if(tradeFilter.test(t)){
                stocks.add(tradeTransformer.apply(t));
            }
        }

        return stocks;
    }

    public static Function<Trade,String> getStockSymbolWithVolume(){
        return (trade) -> trade.getStock().getSymbol() + "-" + trade.getVolume();
    }

    public static Function<Trade,String> getStockNameSymbolWithVolume(){
        return (trade) -> trade.getStock().getName() + "-" + trade.getStock().getSymbol() + "-" + trade.getVolume();
    }
}
