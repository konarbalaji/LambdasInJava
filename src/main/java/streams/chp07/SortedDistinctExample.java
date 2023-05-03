package streams.chp07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDistinctExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Sergio","Sunil","Paul","Ana","Michelle","Sunil","Sergio","Anita");
        List<String> sortedNames = fetchLongNamesSorted(names);
        System.out.println("Names Sorted : " + sortedNames);

        List<String> sortedDistinctNames = SortedDistinctExample.fetchDistinctLongNames(sortedNames);
        System.out.println("Upper case names : " + sortedDistinctNames);

    }

    private static List<String> fetchLongNamesSorted(List<String> names) {
        return names.stream()
                .filter(name -> name.length()>3)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> fetchDistinctLongNames(List<String> names){
        return names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
