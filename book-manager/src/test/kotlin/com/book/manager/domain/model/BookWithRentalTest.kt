package com.book.manager.domain.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

internal class BookWithRentalTest {
    @Test
    fun `isRental when rental is null then return false`() {
        // Arrange
        val book = Book(1, "kotlin ", "kot", LocalDate.now())

        // Act
        val bookWithRental = BookWithRental(book, null)

        // Assert
        assertThat(bookWithRental.isRental).isEqualTo(false)
    }

    @Test
    fun `isRental when rental is not null then return true`() {
        // Arrange
        val book = Book(1, "kotlin ", "kot", LocalDate.now())
        val rental = Rental(1, 100, LocalDateTime.now(), LocalDateTime.MAX)

        // Act
        val bookWithRental = BookWithRental(book, rental)

        // Assert
        assertThat(bookWithRental.isRental).isEqualTo(true)
    }
}
