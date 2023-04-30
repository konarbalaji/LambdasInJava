package lambdas.chp04;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestTransactions {

    public static void main(String[] args) {

        List<Trade> trades = TradeUtil.getTrades();

        //1.Get Symbol of stocks where volume is >= 1 million
        System.out.println("1.Get Symbol of stocks where volume is >= 1 million");
        List<String> highVolumeStocks = Exchange.getHighVolumeStocks(trades);
        System.out.println(highVolumeStocks);

        //2.Get all Buy Transactions
        System.out.println("2.Get all Buy Transactions");
        List<String> stocksPurchased = Exchange.getStocksByTradeType(trades,TradeType.BUY);
        System.out.println("Buy Trades : " + stocksPurchased);

        //3.Get all SELL Transactions
        System.out.println("2.Get all SELL Transactions");
        List<String> stocksSold = Exchange.getStocksByTradeType(trades,TradeType.SELL);
        System.out.println("Buy Trades : " + stocksSold);

        System.out.println("Refactored code to use Predicate & Function");
        //1. High Volume
        System.out.println("Refactored High Volume Stocks");

        Predicate<Trade> highVolumeStock = (Trade trade) -> trade.getVolume()>=1000000;
        Function<Trade, String> highVolumeStockSymbol = (Trade trade) -> trade.getStock().getSymbol();
        System.out.println(Exchange.getStock(trades, highVolumeStock, highVolumeStockSymbol));

        //2.Buy
        Predicate<Trade> buyTrades = (Trade trade) -> trade.getTradeType()==TradeType.BUY;
        System.out.println(Exchange.getStock(trades,buyTrades,Exchange.getStockSymbolWithVolume()));

        //3. SOLD stocks
        Predicate<Trade> sellTrades = (Trade trade) -> trade.getTradeType()==TradeType.SELL;
        System.out.println(Exchange.getStock(trades,sellTrades,Exchange.getStockSymbolWithVolume()));

        //Shows how the getSTockNameSymbolWithVolume was plugged into the getStock API.
        System.out.println("\n Refactored - Stocks sold with name and description");
        System.out.println(Exchange.getStock(trades,sellTrades, Exchange.getStockNameSymbolWithVolume()));


    }
}
