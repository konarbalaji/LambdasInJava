package ch01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

public class SortByLengthNatOrder {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Biggest","at","ate","I","apple","ball","cat","rhino","series");

        //Sorting prior to Java 8
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                if(s1.length() > s2.length())
                    return 1;
                else if(s1.length() < s2.length())
                    return -1;

                return s1.compareTo(s2);
            }
        });

        System.out.println(strings);

        //Sorting after Java 8
        List<String> res = strings.stream()
                .sorted(comparing(String::length).thenComparing(naturalOrder()))
                .collect(Collectors.toList());

        System.out.println(res);
    }
}