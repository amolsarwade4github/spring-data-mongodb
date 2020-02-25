package com.example.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "movies")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private Integer id;
    private String name;
    private int year;

}
