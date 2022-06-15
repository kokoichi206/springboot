package jp.mydns.kokoichichi0206.firstboot.kokoichi.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.BankDataSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    // relaxed = true means always return default values, don't care about the return value
    private val dataSource: BankDataSource = mockk(relaxed = true)

    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data to retrieve banks`() {
        // given

        // when
        val banks = bankService.getBanks()

        // then
        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}