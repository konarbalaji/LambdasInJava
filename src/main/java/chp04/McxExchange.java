package chp04;

public class McxExchange {

    Commodity prodToTrade = null;

    public static void main(String[] args) {


        CommodityFactory.registerNewCommodity("mentha", () -> new Mentha());

        McxExchange exch = new McxExchange();
        CommodityFactory.getCommodity("gold").buy();
        CommodityFactory.getCommodity("crude").buy();
        CommodityFactory.getCommodity("soybean").buy();
        CommodityFactory.getCommodity("test").buy();
    }

    public void trade(){

        String comm = getCommodity();

        if(comm.equals("gold")){
            prodToTrade=new Gold();
        }else if(comm.equals("crude")){
            prodToTrade=new CrudeOil();
        }else if(comm.equals("soybean")){
            prodToTrade=new SoyBean();
        }

        prodToTrade.buy();
    }

    public static String getCommodity(){
        return "crude";
    }

}