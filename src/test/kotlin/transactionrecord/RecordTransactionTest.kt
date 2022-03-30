package transactionrecord

import model.Account
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import service.AccountService

internal class RecordTransactionTest{

    private val recordTransaction= RecordTransaction()
    private val accountService = AccountService(recordTransaction)


    @Test
    fun `should retrieve 2 operations`() {
        //given
        accountService.listOfAccount.add(Account(1200))
        val amountToDeposit = 300
        val amountToWithdraw = 200

        //when
        accountService.deposit(amountToDeposit)
        accountService.withdraw(amountToWithdraw)

        //then
        assertEquals(recordTransaction.listOfOperation.size, 2)
    }


    @Test
    fun `should print 2 operations with 2 differents operations types`() {
        //given
        accountService.listOfAccount.add(Account(1200))
        val amountToDeposit = 300
        val amountToWithdraw = 200
        val expectedOperationType = Pair(OPERATION_DEPOSIT, OPERATION_WITHDRAW)

        //when
        accountService.deposit(amountToDeposit)
        accountService.withdraw(amountToWithdraw)

        //then
        assertEquals(recordTransaction.listOfOperation.first().operationType, expectedOperationType.first)
        assertEquals(recordTransaction.listOfOperation.last().operationType, expectedOperationType.second)
        accountService.printAllHistoricOperation()
    }

    companion object{
        private const val OPERATION_DEPOSIT = "deposit"
        private const val OPERATION_WITHDRAW = "withdraw"
    }
}