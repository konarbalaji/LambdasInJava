package lambdas.chp04;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {

        //T get()

        //1st Example

        long start = System.currentTimeMillis();

        for(int i=0; i<100; i++){
            Supplier<Integer> val = () -> 42;
        }

        System.out.println("Time taken loop with autoboxing : " + (System.currentTimeMillis()-start));

        long start1 = System.currentTimeMillis();

        for(int i=0; i<100; i++){
            IntSupplier val = () -> 42;
        }

        System.out.println("Time taken loop without autoboxing : " + (System.currentTimeMillis()-start1));

        //Example Three - Get 2 coupons randomly
        System.out.println("Two Coupons : ");
        System.out.println(Coupons.getAvailableCoupons(2, () -> Coupons.getCoupons()));

        //2. Get total of 6 coupons randomly but budgets restricted to $500
        System.out.println("Get 6 Coupons restricted to $500");
        System.out.println(Coupons.getAvailableCoupons(6, () -> Coupons.getCouponsUpto500Max()));

        System.out.println("Getting top valued coupon");
        Supplier<String> getTopValuedCoupon = () -> Coupons.getTopValuedCoupon();
        System.out.println(Coupons.getAvailableCoupons(10,getTopValuedCoupon));

    }
}