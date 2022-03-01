package model

import java.time.Instant

data class Operation(
    val id: String,
    val accountId: String,
    val amount: Double,
    val date: Instant = Instant.now()
)
