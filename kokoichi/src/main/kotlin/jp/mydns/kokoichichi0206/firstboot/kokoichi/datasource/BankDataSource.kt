package jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource

import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
}