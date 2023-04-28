package chp04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {

        //void accept(T t);

        //Example one - Simple Consumer
        System.out.println("=======> Example 1 : Display on console");
        Consumer<String> simpleDisplay = (String s) -> System.out.println(s);
        simpleDisplay.accept("Hello Lambdas consumer");

        //Example 2 - store String in Database
        System.out.println("=======> Example 2 - store String in Database");
        Consumer<String> updateDb = str -> storeInDB(str);
        updateDb.accept("Storing in DB");

        //Example 3 - Method accepts Consumer as Parameter
        System.out.println("=======> Example 3 - Method accepts Consumer as Parameter");
        performOperationWith("Lambdas",simpleDisplay);
        performOperationWith("Lambdas",updateDb);

        //Example 4 - Formatting Strings
        System.out.println("=======> Example 4 - Formatting Strings");
        Consumer<String> displayWithSpaces = (s) -> System.out.println(String.format("%20s", s));
        displayWithSpaces.accept("Balaji");

        //Example five - Show andThen in action
        System.out.println("=======> Example five - Chaining - andThen()");
        StringBuilder sb = new StringBuilder("lambdas");

        Consumer<StringBuilder> changeCase = sb1 -> sb1.append(sb1.toString().toUpperCase());
        Consumer<StringBuilder> print = sb1 -> System.out.println(sb1);

        Consumer<StringBuilder> chained = changeCase.andThen(print);
        chained.accept(new StringBuilder("testasdff"));

        //Example 6 - Using Generics
        System.out.println("=======> Example 6 - Using Generics");
        List<String> stringsArr = Arrays.asList("Java","Lambdas","Spring");
        performOperationWithGenerics(stringsArr, (a) -> System.out.println(a.toUpperCase()));

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        performOperationWithGenerics(nums, (n) -> System.out.println(n*n));

    }

    //Passing Behavior
    private static <T> void performOperationWithGenerics(List<T> list, Consumer<T> cons) {
        if(list!=null){
            for(T t : list)
                cons.accept(t);
        }
    }

    private static void performOperationWith(String lambdas, Consumer<String> consumer) {
        consumer.accept(lambdas);
    }

    private static void storeInDB(String str) {
        System.out.println(" Store in DB ==> " + str);
    }
}