package jp.mydns.kokoichichi0206.firstboot.kokoichi.model

// data class auto implements equals, hashCode, toString
data class Bank(
    val accountNumber: String,
    val trust: Double,
    val transactionFee: Int
)
