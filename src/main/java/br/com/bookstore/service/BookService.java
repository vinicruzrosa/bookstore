package br.com.bookstore.service;

import br.com.bookstore.model.Book;
import br.com.bookstore.model.repository.BookRepository;

import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        if (!bookRepository.existsById(book.getId())) {
            throw new IllegalArgumentException("Book with id " + book.getId() + " not found");
        }
        return bookRepository.save(book);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book with id " + id + " not found"));
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }
}
