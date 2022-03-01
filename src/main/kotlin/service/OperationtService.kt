package service

import model.Client
import model.Operation

class OperationService(private val accountService: AccountService){

    val listOfOperations: MutableList<Operation> = mutableListOf()

    fun depositInAccount(operation: Operation){
        accountService.updateAccount(operation.accountId, operation.amount)
        listOfOperations.add(operation)
    }

    fun withdrawalInAccount(operation: Operation){
        accountService.updateAccount(operation.accountId, - operation.amount)
        listOfOperations.add(operation)
    }

    fun findAllOperations(accountId:String): List<Operation>{
        return accountId.takeIf { listOfOperations.any { it.accountId == accountId } }?.let {
            listOfOperations.filter { it.accountId == accountId }
        }  ?: throw Exception("No operation found with this account $accountId")
    }

}