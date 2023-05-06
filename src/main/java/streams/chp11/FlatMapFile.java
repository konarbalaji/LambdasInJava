package streams.chp11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapFile {

    private static String FILE_PATH = "D:\\UDEMY_COURSES\\LambdasInJava_Git\\LambdasInJava\\src\\main\\java\\streams\\chp11\\flatmap.txt";

    public static void main(String[] args) throws IOException {

        //1. Example of Arrays.stream
        String str[] = {"a","e","i","o","u"};

        Stream<String> arrStream = Arrays.stream(str);
        arrStream.forEach(System.out::println);

        //2.Example of splitting a string and then streaming over it
        String input = "I,am,learning,lambdas,and,stream";

        String[] splitArray = input.split(",");
        Stream<String> splitStream = Arrays.stream(splitArray);
        splitStream.forEach(System.out::println);

        //3. Example of reading a file and displaying each word

        /**
         *1.Read the file. - Stream<String>
         *2.Process a line, a line can have more than 1 word,hence map? line ->words
         *3.Process words.
         */

        System.out.println("============================");
        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH)))
        {
            Stream<String> line = lines.flatMap(l -> Arrays.stream(l.split("\\s+")));
            line.forEach(System.out::println);

        }



    }
}
