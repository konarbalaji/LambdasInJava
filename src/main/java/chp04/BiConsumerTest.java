package chp04;

import java.util.HashMap;
import java.util.Map;

public class BiConsumerTest {

    public static void main(String[] args) {
        Map<Integer, String> lengthStrings = new HashMap<>();

        lengthStrings.put(4,"java");
        lengthStrings.put(6,"spring");
        lengthStrings.put(7,"lambdas");

        System.out.println("==========================");
        System.out.println("Usual Way : ");

        //Typical way
        for(Map.Entry<Integer, String> entrySet : lengthStrings.entrySet()){
            System.out.println("Key is " + entrySet.getKey() + " Value is " + entrySet.getValue());
        }

        System.out.println("==========================");
        lengthStrings.forEach((K,V) -> System.out.println("Key is " + K + " Value is " + V));
    }
}
