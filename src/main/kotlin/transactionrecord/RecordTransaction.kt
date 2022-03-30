package transactionrecord

import model.Operation


class RecordTransaction: RecordTransactionI {

    val listOfOperation : MutableList<Operation> = mutableListOf()

    override fun recordTransaction(operation: Operation) {
        listOfOperation.add(operation)
    }
}