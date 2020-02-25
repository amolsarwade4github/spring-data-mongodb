package com.example.mongodb.config;

import com.example.mongodb.document.Movie;
import com.example.mongodb.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.mongodb")
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //MEMO: To create initial records.
                List<Movie> movies = getMovies();
                movieRepository.saveAll(movies);
            }
        };
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "The 400 Blows", 1959));
        movies.add(new Movie(2, "La Haine", 1995));
        movies.add(new Movie(3, "The Godfather", 1972));
        movies.add(new Movie(4, "Man Bites Dog", 1992));
        movies.add(new Movie(5, "The Departed", 2006));
        return movies;
    }

}
