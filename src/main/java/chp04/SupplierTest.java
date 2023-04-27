package chp04;

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


        //2nd
    }
}
