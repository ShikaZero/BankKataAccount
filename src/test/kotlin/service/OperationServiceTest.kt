package service

import model.Operation
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class OperationServiceTest{


    private val accountService = AccountService()
    private val operationService = OperationService(accountService)

    @Test
    fun `should depose an amount on an account`() {
        //given
        val operation = Operation("0", "0", 500.0)

        //when
        operationService.depositInAccount(operation)

        //then
        assertEquals(true, operationService.listOfOperations.any{ it.id == operation.id})
        assertEquals(true, operationService.listOfOperations.any{ it.amount == operation.amount})
        assertEquals(true, operationService.listOfOperations.any{ it.accountId == operation.accountId})

    }

    @Test
    fun `should withdrawal an amount on an account`() {
        //given
        val operation = Operation("1", "0", 200.0)

        //when
        operationService.withdrawalInAccount(operation)

        //then
        assertEquals(true, operationService.listOfOperations.any{ it.id == operation.id})
        assertEquals(true, operationService.listOfOperations.any{ it.amount == operation.amount})
        assertEquals(true, operationService.listOfOperations.any{ it.accountId == operation.accountId})

    }

    @Test
    fun `should return all existing operations`() {
        //given
        val accountId = "0"
        val operationOne = Operation("0", "0", 500.0)
        val operationTwo = Operation("0", "0", 800.0)
        val operationThree = Operation("0", "0", 200.0)

        //when
        operationService.depositInAccount(operationOne)
        operationService.depositInAccount(operationTwo)
        operationService.withdrawalInAccount(operationThree)
        val operations = operationService.findAllOperations(accountId)

        //then
        assertTrue(operations.size > 2)

    }
}