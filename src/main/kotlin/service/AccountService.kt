package service

import model.Account

class AccountService {

    var listOfAccounts: MutableList<Account> = mutableListOf(
        Account("0", 500.0, "0")
    )

    fun createAccount(account: Account){
        listOfAccounts.add(account)
    }

    fun updateAccount(accountId: String, amount: Double){
        listOfAccounts.firstOrNull{ it.id  == accountId }?.let { it.balance =
            listOfAccounts.first{account -> account.id  == accountId }.balance.plus(amount) }
            ?: throw Exception("No account found with this id $accountId")
    }

    fun findAccountByClientId(accountId: String): Account{
        return accountId.takeIf { listOfAccounts.any { it.id == accountId } }?.let {
            listOfAccounts.first { it.id == accountId }
        }  ?: throw Exception("No account found with this id $accountId")
    }
}