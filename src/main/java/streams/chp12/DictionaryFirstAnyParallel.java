package streams.chp12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import static streams.chp08.DictionaryFindFirstAny.findWordStartingFrom;

public class DictionaryFirstAnyParallel {

    private static String FILE_PATH = "D:\\UDEMY_COURSES\\LambdasInJava_Git\\LambdasInJava\\src\\main\\java\\streams\\chp12\\dictionary.txt";

    public static void main(String[] args) throws IOException {

        //Find a word that starts with 'a' and is greater than 10 chars, convert to uppercase

        String firstLetter = "a";
        findWordStartingFromLetter(firstLetter);

    }

    private static void findWordStartingFromLetter(String firstLetter) throws IOException {

        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){
            Optional<String> anyLargeWords = lines.parallel()
                                                .filter(w -> w.length() > 10)
                                                .filter(w -> w.startsWith(firstLetter))
                                                .map(w -> w.toUpperCase())
                                                .findAny();

            System.out.println(anyLargeWords.orElse("No word starting from " + firstLetter + " found "));
        }
    }
}
