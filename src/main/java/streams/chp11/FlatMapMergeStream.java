package streams.chp11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapMergeStream {
    public static void main(String[] args) {

        List<Integer> system1 = Arrays.asList(1,2,3,4);
        List<Integer> system2 = Arrays.asList(5,6,7);
        List<Integer> system3 = Arrays.asList(8,9,10);

        Stream<List<Integer>> numbers = Stream.of(system1, system2, system3);

        System.out.println("numbers : " + numbers);

        //Attempt 1
        List<List<Integer>> merged = numbers.map(numlist -> numlist)
                                            .collect(Collectors.toList());

        //merged.stream().forEach(l -> l.stream().forEach( s ->System.out.print(s + " ")));

        System.out.println("\nmerged" + merged);

        //Attempt 2 -
        numbers = Stream.of(system1, system2, system3);
        List<Stream<Integer>> mergedStream = numbers.map(num -> num.stream())
                                                .collect(Collectors.toList());

        System.out.println("\nmergedStream : " + mergedStream);

        //Attempt 3
        numbers = Stream.of(system1, system2, system3);
        List<Stream<Integer>> mergedStreamHammeredOut = numbers.map(num -> num.stream())
                                                                .collect(Collectors.toList());

        System.out.println("\nmergedStreamHammeredOut : " + mergedStreamHammeredOut);

    }
}