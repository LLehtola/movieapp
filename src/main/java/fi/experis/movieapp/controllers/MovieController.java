package fi.experis.movieapp.controllers;

import fi.experis.movieapp.models.Movie;
import fi.experis.movieapp.repositories.MovieRepository;
import fi.experis.movieapp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.saveMovie(movie);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(newMovie, status);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.getAllMovies();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(movies, status);
    }



}
