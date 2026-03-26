package dev.jannick.bookmanagment.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity //says spring, databasetable is empty
@Data //lombok generated automatic all getter and setter and toString()
public class Book {

    @Id //tells JPA this field is a primary krey in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tells the database do the ID automatic
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private int releaseyear;
    private boolean read;
}
