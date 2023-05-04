package streams.chp08.exercise;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ExerciseOneSolution {

    public static Set<String> names = Set.of("software","programmer","i","an","a","java","the");
    public static Set<String> articles = Set.of("a","an","the");

    public static void main(String[] args) {

        String art = names.stream()
                .filter(a -> articles.contains(a))
                .map(String::toUpperCase)
                .findFirst()
                .orElse("No Articles found");

        System.out.println(art);

    }
}