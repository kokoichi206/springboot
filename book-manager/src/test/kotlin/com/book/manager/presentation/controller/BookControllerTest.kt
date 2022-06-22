package com.book.manager.presentation.controller

import com.book.manager.app.core.book.BookController
import com.book.manager.domain.model.Book
import com.book.manager.domain.model.BookWithRental
import com.book.manager.presentation.BookInfo
import com.book.manager.presentation.GetBookListResponse
import com.book.manager.app.core.book.BookService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.nio.charset.StandardCharsets
import java.time.LocalDate

internal class BookControllerTest {
    private val bookService = mock<BookService>()

    private val bookController = BookController(bookService)

    @Test
    fun `getList is success`() {
        // Arrange
        val bookId = 100L
        val book = Book(bookId, "kokkokko", "Taro", LocalDate.now())
        val bookList = listOf(BookWithRental(book, null))

        whenever(bookService.getList()).thenReturn(bookList)

        val expectedResponse = GetBookListResponse(listOf(BookInfo(bookId, "kokkokko", "Taro", false)))
        val expected = ObjectMapper().registerKotlinModule().writeValueAsString(expectedResponse)
        val mockMvc = MockMvcBuilders.standaloneSetup(bookController).build()

        // Act
        val httpSession = mockMvc.perform(get("/book/list"))

        // Arrange
        val resultResponse = httpSession
            .andExpect(status().isOk).andReturn().response
        val result = resultResponse.getContentAsString(StandardCharsets.UTF_8)
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
