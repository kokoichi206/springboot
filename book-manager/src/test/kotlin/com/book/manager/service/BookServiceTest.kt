package com.book.manager.service

import com.book.manager.domain.model.Book
import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.repository.BookRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test
import java.time.LocalDate
import org.assertj.core.api.AssertionsForClassTypes.assertThat

internal class BookServiceTest {
    private val bookRepository = mock<BookRepository>()

    private val bookService = BookService(bookRepository)

    @Test
    fun `getList when book list is exist then return list`() {
        // Arrange
        val book = Book(1, "kotlin", "kotlin af", LocalDate.now())
        val bookWithRental = BookWithRental(book, null)
        val expected = listOf(bookWithRental)

        whenever(bookRepository.findAllWithRental()).thenReturn(expected)

        // Act
        val result = bookService.getList()

        // Assert
        assertThat(expected).isEqualTo(result)
        verify(bookRepository, times(1)).findAllWithRental()
    }
}
