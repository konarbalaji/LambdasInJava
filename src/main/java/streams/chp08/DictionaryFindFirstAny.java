package streams.chp08;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class DictionaryFindFirstAny {

    private static String FILE_PATH = "D:\\UDEMY_COURSES\\LambdasInJava_Git\\LambdasInJava\\src\\main\\java\\streams\\chp08\\dictionary.txt";

    public static void main(String[] args) throws IOException {

        //find the first occurence of large word > 20 characters
        findFirstLargeWord();
        findWordStartingFrom("idol");

    }

    private static void findFirstLargeWord() throws IOException {

        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH)))
        {
            Optional<String> firstLargeWord = lines.filter(w -> w.length() > 20)
                                                .findFirst();

            System.out.println(firstLargeWord.orElse("No Large Word found ..."));
        }
    }

    public static void findWordStartingFrom(String firstLetter) throws IOException {

        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH)))
        {

            Optional<String> res = lines.filter(w -> w.startsWith(firstLetter))
                    .filter(w -> w.length() > 10)
                    .findAny();

            System.out.println(res.orElse("No words starting from : " + firstLetter + " found in txt file"));
        }
    }
}
