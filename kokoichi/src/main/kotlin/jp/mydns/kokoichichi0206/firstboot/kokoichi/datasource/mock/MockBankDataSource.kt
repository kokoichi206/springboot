package jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.mock

import jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.BankDataSource
import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 1),
        Bank("5678", 0.0, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
}