package service

import model.Account
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AccountServiceTest{

    private val accountService = AccountService()

    @Test
    fun `should create a account`() {
        //given
        val account = Account("1", 1200.0, "1")

        //when
        accountService.createAccount(account)

        //then
        assertEquals(true, accountService.listOfAccounts.any{ it.id == account.id})
        assertEquals(true, accountService.listOfAccounts.any{ it.balance == account.balance})
        assertEquals(true, accountService.listOfAccounts.any{ it.clientId == account.clientId})

    }

    @Test
    fun `should update an amount of an account`() {
        //given
        val accountId = "0"
        val amountToDepose = 400.0

        //when
        val accountToTestBeforeUpdate = accountService.findAccountByClientId(accountId).balance + amountToDepose
        accountService.updateAccount(accountId, amountToDepose)
        val accountToTestAfterUpdate = accountService.findAccountByClientId(accountId).balance

        //then
        assertEquals(accountToTestBeforeUpdate , accountToTestAfterUpdate)

    }

    @Test
    fun `should update a negative amount of an account`() {
        //given
        val accountId = "0"
        val amountToWithdrawal = 400.0

        //when
        val accountToTestBeforeUpdate = accountService.findAccountByClientId(accountId).balance - amountToWithdrawal
        accountService.updateAccount(accountId, - amountToWithdrawal)
        val accountToTestAfterUpdate = accountService.findAccountByClientId(accountId).balance

        //then
        assertEquals(accountToTestBeforeUpdate , accountToTestAfterUpdate)

    }

    @Test
    fun `should return an Exception if account id doest not exist when updating`() {

        //given
        val accountId = "50"
        val expectedMessage = "No account found with this id $accountId"

        //when
        val exception: Exception = assertThrows(Exception::class.java) { accountService.updateAccount(accountId, 0.0) }

        //then
        assertTrue(exception.message.orEmpty().contains(expectedMessage));

    }

    @Test
    fun `should find a account`() {

        //given
        val accountId = "0"

        //when
        val accountResult = accountService.findAccountByClientId(accountId)

        //then
        assertTrue(accountResult.id == accountId)

    }

    @Test
    fun `should return an Exception if account id doest not exist`() {

        //given
        val accountId = "50"
        val expectedMessage = "No account found with this id $accountId"

        //when
        val exception: Exception = assertThrows(Exception::class.java) { accountService.findAccountByClientId(accountId) }

        //then
        assertTrue(exception.message.orEmpty().contains(expectedMessage));

    }

}