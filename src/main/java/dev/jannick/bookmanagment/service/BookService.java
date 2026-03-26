package dev.jannick.bookmanagment.service;

import dev.jannick.bookmanagment.model.Book;
import dev.jannick.bookmanagment.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //tells spring that this is service logic
@RequiredArgsConstructor //lombok generates auto constructor for all finals
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book bookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found: " + id));
    }

    public List<Book> notRead() {
        return bookRepository.findByReadFalse();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Long id, Book neu) {
        Book book = bookById(id);
        book.setTitle(neu.getTitle());
        book.setAuthor(neu.getAuthor());
        book.setIsbn(neu.getIsbn());
        book.setReleaseyear(neu.getReleaseyear());
        book.setRead(neu.isRead());
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
