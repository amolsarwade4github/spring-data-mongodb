package com.example.mongodb.repository;

import com.example.mongodb.document.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, Integer> {

}
