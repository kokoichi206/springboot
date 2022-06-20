package com.book.manager.presentation.controller

import com.book.manager.presentation.BookInfo
import com.book.manager.presentation.GetBookDetailResponse
import com.book.manager.presentation.GetBookListResponse
import com.book.manager.service.BookService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("book")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")
class BookController(
    private val bookService: BookService,
) {

    @GetMapping("/list")
    fun getList(): GetBookListResponse {
        val bookList = bookService.getList().map {
            BookInfo(it)
        }
        return GetBookListResponse(bookList)
    }

    @GetMapping("/detail/{book_id}")
    fun getDetail(@PathVariable("book_id") bookId: Long): GetBookDetailResponse {
        val book = bookService.getDetail(bookId)
        return GetBookDetailResponse(book)
    }
}
