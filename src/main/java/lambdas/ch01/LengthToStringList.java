package lambdas.ch01;

import java.util.*;
import java.util.stream.Collectors;

public class LengthToStringList {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Biggest","at","ate","I","apple","ball","cat","rhino","series");

        Map<Integer, List<String>> lengthMap = new HashMap<>();

        for(String string : strings){
            List<String> sameLength = null;
            Integer length = string.length();

            if(lengthMap.get(length) == null){
                //string of same length was never added, create new List & add this string to ti
                sameLength = new ArrayList<>();
                lengthMap.put(length,sameLength);
            }else{
                sameLength = lengthMap.get(length);
            }

            sameLength.add(string);
        }

        System.out.println(lengthMap);

        //SAme solution with java 8
        Map<Integer, List<String>> res = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(res);

    }
}
