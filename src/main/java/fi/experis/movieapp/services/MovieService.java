package fi.experis.movieapp.services;

import fi.experis.movieapp.models.Movie;
import fi.experis.movieapp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public boolean movieExists(String genre) {
        return movieRepository.existsByGenre(genre);
    }

    // Method for getting movies by genre
    public List<Movie> getMoviesForGenre(String genre) {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Movie> allMovies = new ArrayList<>();
        allMovies.addAll(movieRepository.findAll());
        for(Movie movie : allMovies) {
            if(movie.getGenre().equalsIgnoreCase(genre)) {
                movies.add(movie);
            }
        }
        return movies;
    }
}
