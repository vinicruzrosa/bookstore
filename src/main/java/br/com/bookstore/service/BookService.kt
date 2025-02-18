package br.com.bookstore.service

import br.com.bookstore.model.Book
import br.com.bookstore.model.repository.BookRepository

class BookService(
    private val bookRepository: BookRepository
) {
    fun saveBook(book: Book): Book {
        return bookRepository.save(book)
    }

    fun updateBook(book: Book): Book {
        if (!bookRepository.existsById(book.id)) {
            throw IllegalArgumentException("Book with id \${book.id} not found")
        }
        return bookRepository.save(book)
    }

    fun listAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Book {
        return bookRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Book with id \$id not found") }
    }

    fun deleteBook(id: Long) {
        if (!bookRepository.existsById(id)) {
            throw IllegalArgumentException("Book with id \$id not found")
        }
        bookRepository.deleteById(id)
    }
}