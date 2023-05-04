package streams.chp08.exercise;

import lambdas.chp04.RemoveIfTest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExerciseTwoSolution {

    public static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {


        //Exercise 2 - Find first rocky movie
        findFirstRockieMovie();

        //Exercise 3  -are there any movies starting with Will Smith in 2020
        willSmithMovie2020();
    }

    private static void willSmithMovie2020() {
        boolean willIn2020 = movies.stream()
                                    //.filter(m -> m.getCast().contains("Will Smith"))
                                    .anyMatch(m -> ((m.getDateOfRelease().getYear() == 2020) && (m.getCast().contains("Will Smith"))));

        System.out.println("willIn2020 : " + willIn2020);
    }

    private static void findFirstRockieMovie() {

        Comparator<Movie> byReleaseDate = Comparator.comparing(Movie::getDateOfRelease);

        Optional<Movie> res = movies.stream()
                                    .filter(m -> m.getName().contains("Rocky"))
                                    .sorted(byReleaseDate)
                                    .findFirst();

        System.out.println(res.orElseThrow());
    }

}
