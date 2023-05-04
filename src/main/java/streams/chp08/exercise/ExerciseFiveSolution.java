package streams.chp08.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ExerciseFiveSolution {

    public static String filePath = "D:\\UDEMY_COURSES\\LambdasInJava_Git\\LambdasInJava\\src\\main\\java\\streams\\chp08\\exercise\\sample.txt";

    public static void main(String[] args) throws IOException {

        boolean isFileValid = true;

        try(Stream<String> lines = Files.lines(Paths.get(filePath)))
        {
         isFileValid = lines.allMatch(line -> line.startsWith("#") && line.endsWith("#"));
        }

        System.out.println("isFileValid : " + isFileValid);
    }
}