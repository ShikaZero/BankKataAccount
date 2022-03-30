package service

import model.Account
import model.Operation
import transactionrecord.RecordTransaction
import java.time.Instant

class AccountService(private val recordTransaction: RecordTransaction) {

    val listOfAccount: MutableList<Account> = mutableListOf()

    fun deposit(amount: Int){
        recordTransaction.recordTransaction(Operation(
                listOfAccount.first().balance,
                amount,
                Instant.now(),
                OPERATION_DEPOSIT
            )
        )
        listOfAccount.first().balance += amount
    }

    fun withdraw(amount: Int){
        recordTransaction.recordTransaction(Operation(
            listOfAccount.first().balance,
            amount,
            Instant.now(),
            OPERATION_WITHDRAW
            )
        )
        listOfAccount.first().balance -= amount
    }

    fun printAllHistoricOperation(){
        println(recordTransaction.listOfOperation)
    }

    companion object{
        private const val OPERATION_DEPOSIT = "deposit"
        private const val OPERATION_WITHDRAW = "withdraw"
    }
}