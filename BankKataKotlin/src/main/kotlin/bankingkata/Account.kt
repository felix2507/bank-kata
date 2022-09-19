package bankingkata

class Account(
    private val transactionLog: TransactionLog
) {

    fun withdraw(amount: Int) {
        transactionLog.addWithdraw(amount)
    }

    fun deposit(amount: Int) {
        transactionLog.addDeposit(amount)
    }

    fun printStatement() {
        TODO("Not yet implemented")
    }
}

