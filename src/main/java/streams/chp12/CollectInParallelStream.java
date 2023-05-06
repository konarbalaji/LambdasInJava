package streams.chp12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectInParallelStream {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("add","eel","very","watt","i","owl","us");

        for(int i=0; i<5; i++){

            List<String> vowels =
            words.parallelStream()
                    .filter(w -> startsWithVowel(w))
                    //.forEach(w -> vowels.add(w));
                            .collect(Collectors.toList());

            System.out.println(vowels);

        }
    }

    private static boolean startsWithVowel(String w) {
        return (w.startsWith("a") || w.startsWith("e") || w.startsWith("i") || w.startsWith("o") || w.startsWith("u"));
    }

}