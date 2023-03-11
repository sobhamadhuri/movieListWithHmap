/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.movie;


import java.util.*;
import org.springframework.web.server.ResponseStatusException;;
import org.springframework.http.HttpStatus;
// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here
    int uniqueId=6;

    @Override
    public ArrayList<Movie> getMovies(){
        Collection<Movie> moviesValues = movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(moviesValues);
        return movies;
    }

    @Override
    public Movie getMovieById(int movieId){
        Movie existingMovie = movieList.get(movieId);
        if (existingMovie==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return existingMovie;
    }

    @Override
    public Movie addMovie(Movie movie){
        movie.setMovieId(uniqueId);
        movieList.put(uniqueId, movie);
        Movie movie1 = movieList.get(uniqueId);
        uniqueId+=1;
        return movie1;

    }

    @Override
    public Movie updateMovie(int movieId, Movie movie){
        Movie existingMovie = movieList.get(movieId);
        if (existingMovie==null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (movie.getMovieName()!=null){
            existingMovie.setMovieName(movie.getMovieName());
        }
        if (movie.getLeadActor()!=null){
            existingMovie.setLeadActor(movie.getLeadActor());
        }
        
        return existingMovie;
    }

    @Override
    public void deleteMovie(int movieId){
        Movie existingMovie = movieList.get(movieId);
        if (existingMovie!=null){
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}



