package streams.chp07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OnePassStreams {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("I","am","Learning","Lambdas","and","streams");

        List<String> output = strings.stream()
                                        .filter(OnePassStreams::filterByLength)
                                        .map(OnePassStreams::transformToUpperCase)
                                        .collect(Collectors.toList());
    }

    public static boolean filterByLength(String s){
        System.out.println("Filter the string : " + s);
        return s.length()>3;
    }

    public static String transformToUpperCase(String s){
        System.out.println("Xformt he string : " + s);
        return s.toUpperCase();
    }
}
