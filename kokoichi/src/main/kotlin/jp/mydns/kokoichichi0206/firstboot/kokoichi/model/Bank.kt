package jp.mydns.kokoichichi0206.firstboot.kokoichi.model

import com.fasterxml.jackson.annotation.JsonProperty

// data class auto implements equals, hashCode, toString
data class Bank(
    @JsonProperty("account_number")
    val accountNumber: String,
    @JsonProperty("trust")
    val trust: Double,
    @JsonProperty("transaction_fee")
    val transactionFee: Int
)
