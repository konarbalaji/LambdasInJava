package lambdas.chp04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class SimpleFunctionTest {

    public static void main(String[] args) {

        List<String> strings = getData();
        List<Integer> lengthOfStrings = new ArrayList<>();

        //Below operation involves autoboxing to store primitive int into Integer object & tihs may cause performance issue
        Function<String, Integer> lengthFunction = (s) -> s.length();

        //Example 1 - Transform each string to its corresponding length
        for(String s: strings){
            lengthOfStrings.add(lengthFunction.apply(s));
        }

        System.out.println("==========> Example one ");
        System.out.println("Input ==> " + strings);
        System.out.println( "Output ==> " + lengthOfStrings);

        //2 using toIntFunction - primitive
        System.out.println("==========> Example 2 Using toIntFunction");
        lengthOfStrings.clear();

        //Example 3 - Name in upper case.
        //To overcome performance issue cause by boxing operation , we can use ToIntFunction which is primitive specialization of Function
        ToIntFunction<String> length = (s) -> s.length();
        for(String str : strings)
            lengthOfStrings.add(length.applyAsInt(str));
        System.out.println("Input ==> " + strings);
        System.out.println( "Output ==> " + lengthOfStrings);

        //4 . Name in upper case
        List<Customer> customers = getCustomerData();
        Function<Customer, String> nameUpperCase  = (Customer c) -> c.getEmail();
        List<String> customerEmail = new ArrayList<>();

        for(Customer customer : customers){
            customerEmail.add(nameUpperCase.apply(customer));
        }

        System.out.println(customerEmail);

        //5. List<Integer> to int
        List<Integer> numbers = Arrays.asList(1,20,200,33,43,500);

        ToIntFunction<List<Integer>> maxFinder = (numList) -> findMax(numbers);
        int maxval = maxFinder.applyAsInt(numbers);
        System.out.println("Maxvalue : " + maxval);

    }

    private static int findMax(List<Integer> numbers) {

        int max = Integer.MIN_VALUE;

        for(Integer n : numbers){
            if(n>max){
                max=n;
            }
        }

        return max;
    }


    private static List<String> getData() {

        List<String> strings = new ArrayList<>();
        strings.add("i");
        strings.add("am");
        strings.add("learning");
        strings.add("lambdas");
        return  strings;

    }

    private static List<Customer> getCustomerData() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Rahul", "Delta", "rahul@rahul.com", 30));
        customers.add(new Customer("Bob", "Alpha", "bob@bob.com", 35));
        customers.add(new Customer("Alice", "Gamma", "alice@alice.com", 35));
        return customers;
    }
}
