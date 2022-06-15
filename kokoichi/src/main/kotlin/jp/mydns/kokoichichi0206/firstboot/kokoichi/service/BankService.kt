package jp.mydns.kokoichichi0206.firstboot.kokoichi.service

import jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.BankDataSource
import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> {
        return dataSource.retrieveBanks()
    }
}