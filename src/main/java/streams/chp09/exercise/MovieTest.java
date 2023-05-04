package streams.chp09.exercise;

import streams.chp08.exercise.Movie;
import streams.chp08.exercise.MovieUtil;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MovieTest {

    public static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {

        //1. Find the highest grossing movie
        findHighestGrossingMovie();

        //2. Find the lowest grossing movie in the year 2020
        findLowestGrossingMovieIn2020();

        //3.Find the total money grossed by Martin Scorsese films
        findTotGrossByMatinScorsese();

        //4.How many movies were released in the last five years ?
        findMoviesReelasedBeforeYrs();

    }

    private static void findMoviesReelasedBeforeYrs() {

        LocalDate fiveYrsAgo = LocalDate.now().minusYears(10);

        long last5Yrs = movies.stream()
                        .filter(movie -> movie.getDateOfRelease().isAfter(fiveYrsAgo))
                        .count();

        System.out.println("movies were released in the last five years : " + last5Yrs);
    }

    private static void findTotGrossByMatinScorsese() {
        long totGross = movies.stream()
                .filter(movie -> movie.getDirectorName().equals("Martin Scorsese"))
                .mapToLong(movie -> movie.getGrossEarning())
                .sum();

        System.out.println("Total gross by Martin Scorsese is : " + totGross);
    }

    private static void findLowestGrossingMovieIn2020() {

        Comparator<Movie> lowestGrossing = Comparator.comparing(Movie::getGrossEarning);

        Optional<Movie> lowGross = movies.stream()
                                        .filter(movie -> movie.getDateOfRelease().getYear() == 2020)
                                        .min(lowestGrossing);

        System.out.println("Lowest Grossing Movie : " + lowGross.orElseThrow());
    }

    private static void findHighestGrossingMovie() {

        Comparator<Movie> highestGrossing = Comparator.comparing(Movie::getGrossEarning);

        Optional<Movie> highGross = movies.stream()
                                        .max(highestGrossing);

        System.out.println("Highest Grossing movie is : " + highGross.orElseThrow());
    }
}