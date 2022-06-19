package com.book.manager.bookmanager

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookManagerApplicationTests {

    @Test
    fun contextLoads() {
        val result = 3 + 1
        assertEquals(result, 4)
    }
}
