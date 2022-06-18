package com.book.manager.domain.model

import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport
import com.book.manager.infrastructure.database.mapper.Bo

data class BookWithRental(
    val book: Book,
    val rental: RentalDynamicSqlSupport.Rental?,
)
