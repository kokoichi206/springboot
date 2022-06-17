package jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource

import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>

    fun retrieveBank(accountNumber: String): Bank

    fun createBank(bank: Bank): Bank

    fun updateBank(bank: Bank): Bank

    fun deleteBank(accountNumber: String)
}