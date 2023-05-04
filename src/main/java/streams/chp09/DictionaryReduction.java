package streams.chp09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class DictionaryReduction {

    private static final String FILE_PATH = "D:\\UDEMY_COURSES\\LambdasInJava_Git\\LambdasInJava\\src\\main\\java\\streams\\chp09\\dictionary.txt";

    public static void main(String[] args) throws IOException {

        //find the length of the largest word starting from 'a'
        maxLengthOfWordFromA();

        //find the word starting from a that has maximum length
        largestWordFromA();

        //Find the smallest word in dictionary
        smallestWord();

        //Total number of characters in dictionary
        sumTotalCharacters();


    }

    private static void sumTotalCharacters() throws IOException {
        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){
            int res = lines.mapToInt(s->s.length())
                            .reduce(0, Integer::sum);
            System.out.println("Sum is : " + res);
        }
    }

    private static void smallestWord() throws IOException {

        Comparator<String> byLength = Comparator.comparing(s -> s.length());
        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){

            Optional<String> res = lines.min(byLength);

            System.out.println(res.orElse("Word not found"));

        }
    }

    private static void largestWordFromA() throws IOException {

        Comparator<String> byLength = Comparator.comparing(s -> s.length());
        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){

            Optional<String> res = lines.filter(line -> line.startsWith("a"))
                                        .max(byLength);

            System.out.println(res.get());

        }

    }

    private static void maxLengthOfWordFromA() throws IOException {

        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){
            OptionalInt maxLength = lines.filter(line -> line.startsWith("a"))
                    .mapToInt(w -> w.length())
                    //.reduce(0, (a,b) -> a>b ? a : b);
                    .max();

            System.out.println("Max length of word : " + maxLength.orElseThrow());
        }
    }
}