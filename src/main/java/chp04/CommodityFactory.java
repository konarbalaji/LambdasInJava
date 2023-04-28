package chp04;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CommodityFactory {

    private static final Map<String, Supplier<? extends Commodity>> commodities = new HashMap<>();

    static{
        commodities.put("gold" , () -> new Gold());
        commodities.put("crude" , () -> new CrudeOil());
        commodities.put("soybean" , () -> new SoyBean());
    }

    public static void registerNewCommodity(String type, Supplier<? extends Commodity> supplier){
        commodities.put(type,supplier);
    }

    public static Commodity getCommodity(String typeOfCommodity){

        Supplier<? extends Commodity> commSupplier = commodities.get(typeOfCommodity);
        if(null != commSupplier){
            return commSupplier.get();
        }

        throw new IllegalArgumentException("Unknown Commodity : " + typeOfCommodity);

    }

    public static Commodity fetchProductToTrade(String comm){

        Commodity prodToTrade = null;

        if(comm.equals("gold")){
            prodToTrade=new Gold();
        }else if(comm.equals("crude")){
            prodToTrade=new CrudeOil();
        }else if(comm.equals("soybean")){
            prodToTrade=new SoyBean();
        }

        return prodToTrade;
    }
}

interface Commodity {

    public void buy();
}


class CrudeOil implements Commodity{
    @Override
    public void buy() {
        System.out.println("Buying Crude OIl...");
    }
}

class Gold implements Commodity{
    @Override
    public void buy() {
        System.out.println("Buying Gold ...");
    }
}

class SoyBean implements Commodity{
    @Override
    public void buy() {
        System.out.println("Buying SoyBean ...");
    }
}

class Silver implements Commodity{
    @Override
    public void buy() {
        System.out.println("Buying Silver ...");
    }
}

class Mentha implements Commodity{
    @Override
    public void buy() {
        System.out.println("Buying Mentha ...");
    }
}