package streams.chp08.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ExerciseFourSolution {

    private static String FILE_PATH = "D:\\UDEMY_COURSES\\LambdasInJava_Git\\LambdasInJava\\src\\main\\java\\streams\\chp08\\exercise\\invalidpasswords.txt";

    public static void main(String[] args) throws IOException {

        boolean isValidPassword = true;
        String password = "bLaJi";

        try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH)))
        {
            isValidPassword = lines.noneMatch(w -> w.equals(password));
        }
        System.out.println(isValidPassword);
    }
}