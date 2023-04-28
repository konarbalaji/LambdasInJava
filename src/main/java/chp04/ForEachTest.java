package chp04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachTest {

    public static void main(String[] args) {
        List<String> strings = getData();

        //Using Iterator
        System.out.println("Using Iterator...");
        for(Iterator<String> itr = strings.iterator(); itr.hasNext();){
            String s = itr.next();
            System.out.println(s);
        }

        System.out.println("=========================");

        //Enhanced for loop
        for(String s: strings)
            System.out.println(s);

        System.out.println("=========================");

        //Takes Consumer
        strings.forEach(s -> System.out.println(s));

    }

    private static List<String> getData() {

        List<String> strings = new ArrayList<>();
        strings.add("i");
        strings.add("am");
        strings.add("learning");
        strings.add("lambdas");
        return  strings;

    }
}
