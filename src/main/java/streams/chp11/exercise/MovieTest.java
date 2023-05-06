package streams.chp11.exercise;

import streams.chp08.exercise.Movie;
import streams.chp08.exercise.MovieUtil;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieTest {

    public static void main(String[] args) {

        List<Movie> movies = MovieUtil.getMovieData();

        //1.Find list of stars who have acted in Martin Scorsese movies
        List<String> martinMovies = movies.stream()
                            .filter(m -> m.getDirectorName().equalsIgnoreCase("Martin Scorsese"))
                            .flatMap(m -> m.getCast().stream())
                            .collect(Collectors.toList());

        System.out.println("martinMovies            : " + martinMovies);

        //2.Find unique list of stars who have acted in Martin Scorsese movies
        Set<String> martinMoviesUniqueStars = movies.stream()
                                                    .filter(m -> m.getDirectorName().equalsIgnoreCase("Martin Scorsese"))
                                                    .flatMap(m -> m.getCast().stream().distinct())
                                                    .collect(Collectors.toSet());

        System.out.println("martinMoviesUniqueStars : " + martinMoviesUniqueStars);


    }
}
