package com.example.mongodb.resource;

import com.example.mongodb.document.Movie;
import com.example.mongodb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieResource {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Movie getOne(@PathVariable("id") Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No data found for id " + id));
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping(path = "{id}")
    public Movie update(@PathVariable("id") Integer id, @RequestBody Movie movie) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid argument id " + id));
        existingMovie.setName(movie.getName());
        existingMovie.setYear(movie.getYear());
        return movieRepository.save(existingMovie);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Integer id) {
        movieRepository.deleteById(id);
    }
}
