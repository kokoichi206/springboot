package com.book.manager.domain.repository

import com.book.manager.infrastructure.database.record.RentalRecord

interface RentalRepository {
    fun startRental(rental: RentalRecord)
    fun endRental(bookId: Long)
}
