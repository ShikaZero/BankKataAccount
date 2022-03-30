package transactionrecord

import model.Operation

interface RecordTransactionI {

    fun recordTransaction(operation: Operation)

}