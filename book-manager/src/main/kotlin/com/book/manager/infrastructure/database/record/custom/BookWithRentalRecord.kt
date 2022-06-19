package com.book.manager.infrastructure.database.record.custom

import java.time.LocalDate
import java.time.LocalDateTime

data class BookWithRentalRecord(
    val id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null,
    var userId: Long? = null,
    var rentalDateTime: LocalDateTime? = null,
    var returnDateTime: LocalDateTime? = null,
)
