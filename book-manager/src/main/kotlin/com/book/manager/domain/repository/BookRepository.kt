package com.book.manager.domain.repository

import com.book.manager.infrastructure.database.record.BookRecord
import com.book.manager.infrastructure.database.record.custom.BookWithRentalRecord
import java.time.LocalDate

interface BookRepository {
    fun findAllWithRental(): List<BookWithRentalRecord>
    fun findWithRental(id: Long): BookWithRentalRecord?
    fun register(book: BookRecord)
    fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?)
    fun delete(id: Long)
}
