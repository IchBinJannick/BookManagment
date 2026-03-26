package dev.jannick.bookmanagment.service;

import static org.junit.jupiter.api.Assertions.*;

import dev.jannick.bookmanagment.model.Book;
import dev.jannick.bookmanagment.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock //generates faked version of bookRepository
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book();
        book.setId(1L);
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setIsbn("978-0132350884");
        book.setReleaseyear(2008);
        book.setRead(false);
    }

    @Test
    void allBooks_getsAll() {
        when(bookRepository.findAll()).thenReturn(List.of(book));

        List<Book> result = bookService.allBooks();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("Clean Code");
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void bookById_throwException_ifnotthere() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> bookService.bookById(99L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("99");
    }

    @Test
    void save_saveBookCorrect() {
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.save(book);

        assertThat(result.getTitle()).isEqualTo("Clean Code");
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void delete_callRepository() {
        bookService.delete(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void notRead_returnsonlynotread() {
        when(bookRepository.findByReadFalse()).thenReturn(List.of(book));

        List<Book> result = bookService.notRead();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).isRead()).isFalse();
    }

}