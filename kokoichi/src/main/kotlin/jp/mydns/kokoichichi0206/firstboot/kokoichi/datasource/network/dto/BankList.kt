package jp.mydns.kokoichichi0206.firstboot.kokoichi.datasource.network.dto

import jp.mydns.kokoichichi0206.firstboot.kokoichi.model.Bank

data class BankList(
    val results: Collection<Bank>
)
