package streams.chp10.exercise;

import streams.chp08.exercise.Genre;
import streams.chp08.exercise.Movie;
import streams.chp08.exercise.MovieUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieTest {

    private static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {

        //1. Fetch the list of movies by their Genre.
        System.out.println("\n1.Fetch the list of movies by their Genre.");
        Map<Genre, List<Movie>> listByGenre = findListOfMovieByGenre(movies);
        System.out.println(listByGenre);

        //2. Find the number of movies released in each year
        System.out.println("\n2.Find the number of movies released in each year");
        Map<Integer, Long> movieCountByReleaseDate =numberOfMoviesReleasedEachYear(movies);
        System.out.println(movieCountByReleaseDate);

        //3.Find the gross earning of movies classified by genre
        System.out.println("\n3.Find the gross earning of movies classified by genre");
        Map<Genre, Long> grossByGenre = grossEarningByGenre(movies);
        System.out.println(grossByGenre);

        //4. Retrieve a list movies objects with a rating of 4 and 5.
        System.out.println("\n4. Retrieve a list of movies objects with a rating of 4 and 5");
        Map<Integer, List<Movie>> listOf45 = retrieveListOfMoviesObject4_5(movies);
        System.out.println(listOf45);

        //5.Group movies with rating >= 4 but only names of movies.
        System.out.println("\n5.Group movies with rating >= 4 but only names of movies. ");
        Map<Integer, List<String>> byRatingMovieName = movieNamesGroupedByRating(movies);
        System.out.println(byRatingMovieName);

    }

    private static Map<Integer, List<String>> movieNamesGroupedByRating(List<Movie> movies) {
        return movies.stream()
                .filter(movie -> movie.getRating() >= 4)
                .collect(Collectors.groupingBy
                        (
                            Movie::getRating,
                            Collectors.mapping(Movie::getName, Collectors.toList())
                        )
                );
    }

    private static Map<Integer, List<Movie>> retrieveListOfMoviesObject4_5(List<Movie> movies) {
        return movies.stream()
                    .filter(movie -> movie.getRating() >=4)
                    .collect(Collectors.groupingBy(Movie::getRating));
    }


    private static Map<Genre, Long> grossEarningByGenre(List<Movie> movies) {
        return movies.stream()
                    .filter(movie -> movie.getRating() >=4)
                    .collect(Collectors.groupingBy(
                            Movie::getGenre,
                        Collectors.summingLong(Movie::getGrossEarning)));

    }

    private static Map<Integer, Long> numberOfMoviesReleasedEachYear(List<Movie> movies) {
         return movies.stream()
                .collect(Collectors.groupingBy(movie ->
                                movie.getDateOfRelease().getYear(),
                                Collectors.counting()));
    }

    private static Map<Genre, List<Movie>> findListOfMovieByGenre(List<Movie> movies) {
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
    }

}
