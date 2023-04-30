package lambdas.chp04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Coupons {

    private static List<String> coupons = List.of("10$", "100$", "200$", "500$", "1000$", "2000$","2001$");

    public static List<String> getAvailableCoupons(int numberOfCoupons, Supplier<String> couponPattern){

        List<String> availableCoupons = new ArrayList<>();
        for(int i=0; i<numberOfCoupons; i++){
            availableCoupons.add(couponPattern.get());
        }
        return availableCoupons;

    }

    public static String getCoupons() {
        return coupons.get(new Random().nextInt(coupons.size()));
    }

    public static String getCouponsUpto500Max(){
        List<String> newlist = coupons.stream().filter(x -> {
            String val = x.replace("$", "");
            return Integer.valueOf(val) <= 500;
        }).collect(Collectors.toList());

        return newlist.get(new Random().nextInt(newlist.size()));
    }

    public static String getTopValuedCoupon(){

        int max = 0;
        String retVal= "";

        for(int i=0;i< coupons.size();i++){
            int newint = Integer.valueOf(coupons.get(i).replace("$",""));
            if(newint>max){
                max=newint;
            }
        }

        return max+"$";

    }
}
