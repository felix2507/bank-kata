package bankingkata

class Account(
    private val transactionLog: TransactionLog,
    private val statementPrinter: StatementPrinter
) {

    fun withdraw(amount: Int) {
        transactionLog.addWithdraw(amount)
    }

    fun deposit(amount: Int) {
        transactionLog.addDeposit(amount)
    }

    fun printStatement() {
        statementPrinter.printAll(transactionLog.allTransactions)
    }
}

