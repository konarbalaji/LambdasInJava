package chp04;

public class NcdexExchange {

    Commodity prodToTrade = null;

    public static void main(String[] args) {
        NcdexExchange exch = new NcdexExchange();
        exch.trade();
    }

    public void trade(){

        prodToTrade = CommodityFactory.fetchProductToTrade(getCommodity());
        prodToTrade.buy();
    }

    public static String getCommodity(){
        return "soybean";
    }

}