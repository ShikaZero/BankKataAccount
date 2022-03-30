package model

import java.time.Instant

data class Operation(
    val balance: Int,
    val amount: Int,
    val transactionDate: Instant,
    val operationType: String
)
