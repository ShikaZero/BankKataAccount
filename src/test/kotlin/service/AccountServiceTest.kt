package service

import model.Account
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import transactionrecord.RecordTransaction


internal class AccountServiceTest(){

    private val recordTransaction= RecordTransaction()
    private val accountService = AccountService(recordTransaction)


    @Test
    fun `should deposit an amount into an account`() {
        //given
        accountService.listOfAccount.add(Account(1200))
        val amount = 300
        val expectedBalance = 1500

        //when
        accountService.deposit(amount)

        //then
        assertEquals(accountService.listOfAccount.first().balance, expectedBalance)

    }

    @Test
    fun `should withdraw an amount into an account`() {
        //given
        accountService.listOfAccount.add(Account(1500))
        val amount = 200
        val expectedBalance = 1300

        //when
        accountService.withdraw(amount)

        //then
        assertEquals(accountService.listOfAccount.first().balance, expectedBalance)
    }

    @Test
    fun `should retrieve an amount into an account`() {
        //given
        accountService.listOfAccount.add(Account(1500))
        val amount = 200
        val expectedBalance = 1300

        //when
        accountService.withdraw(amount)

        //then
        assertEquals(accountService.listOfAccount.first().balance, expectedBalance)
    }

}