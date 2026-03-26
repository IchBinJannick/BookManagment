package dev.jannick.bookmanagment.controller;

import dev.jannick.bookmanagment.model.Book;
import dev.jannick.bookmanagment.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController //answers HTTP requests and returns automatic JSON
@RequestMapping("/api/books") //all endpoint of this class start wiuth /apo/books
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    //GetMapping, PostMapping, PutMapping, DeleteMapping all HTTP methods that endpoint answers
    //Pathvariable get value of URL
    //RequestBody read JSON-Body of request and transoform automatic in Book objekt
    @GetMapping
    public List<Book> all() {
        return bookService.allBooks();
    }

    @GetMapping("/{id}")
    public Book byId(@PathVariable Long id) {
        return bookService.bookById(id);
    }

    @GetMapping("/unread")
    public List<Book> unread() {
        return bookService.notRead();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.status(201).body(bookService.save(book));
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
