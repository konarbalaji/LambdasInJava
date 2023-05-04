package streams.chp09;

import java.util.Arrays;
import java.util.List;

public class SimpleSumReduction {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //sum the usual way
        sumImperative(numbers);

        //sum using Stream
        sumDeclarative(numbers);

        //Sum of all words - notice the blank words
        List<String> words = Arrays.asList("I","am"," ", "learning", "reductions","streams");

        int totLength = 0;
        for(String word : words){
            if(word != null){
                totLength += word.length();
            }
        }
        System.out.println("Tot Length : " + totLength);

        //total Length using streams & reduce
        totLength = words.stream()
                        .filter(s -> !s.isBlank())
                        .mapToInt(String::length)
                        .boxed()
                        .reduce(0, Integer::sum);

        System.out.println("TotLength : " + totLength);

        //sum is nothing but reduce
        int wordCount = words.stream()
                            .filter(s -> !s.isBlank())
                            .mapToInt(s -> 1)
                            .reduce(0, (a,b) -> a+b);

        System.out.println(words);
        System.out.println("Total Word count : " + wordCount);


    }

    private static void sumImperative(List<Integer> numbers) {
        int sum=0;
        for(Integer n : numbers){
            sum += n;
        }
        System.out.println("Sum the usual way : " + sum);
    }

    private static void sumDeclarative(List<Integer> numbers) {

        int res = numbers.stream()
                .reduce(0, (a , b) -> a+b);

        System.out.println("Sum the declarative way : " + res);
    }
}
