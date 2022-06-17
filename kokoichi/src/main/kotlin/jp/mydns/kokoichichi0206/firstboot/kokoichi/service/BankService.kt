package jp.mydns.kokoichichi0206.firstboot.kokoichi.service

import jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.BankDataSource
import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankService(
    @Qualifier("network") private val dataSource: BankDataSource
) {

    fun getBanks(): Collection<Bank> {
        return dataSource.retrieveBanks()
    }

    fun getBank(accountNumber: String): Bank {
        return dataSource.retrieveBank(accountNumber)
    }

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun deleteBank(accountNumber: String): Unit = dataSource.deleteBank(accountNumber)
}