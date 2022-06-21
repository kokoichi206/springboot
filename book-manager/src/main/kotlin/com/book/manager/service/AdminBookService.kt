package com.book.manager.service

import com.book.manager.domain.model.Book
import com.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class AdminBookService(
    private val bookRepository: BookRepository,
) {
    @Transactional
    fun register(book: Book) {
        bookRepository.findWithRental(book.id)
            ?.let { throw IllegalArgumentException("Already Exist Book ID: ${book.id}") }
        bookRepository.register(book)
    }

    @Transactional
    fun update(bookId: Long, title: String?, author: String?, releaseDate: LocalDate?) {
        bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("Not exist book ID: $bookId")
        bookRepository.update(bookId, title, author, releaseDate)
    }

    @Transactional
    fun delete(bookId: Long) {
        bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("Not exist book ID: $bookId")
        bookRepository.delete(bookId)
    }
}
