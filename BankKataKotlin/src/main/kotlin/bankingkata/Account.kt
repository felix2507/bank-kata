package bankingkata

class Account(val transactionRepository: TransactionRepository, val statementPrinter: StatementPrinter) {

    fun withdraw(amount: Int) {
        transactionRepository.addWithdraw(amount)
    }

    fun deposit(amount: Int) {
        transactionRepository.addDeposit(amount)
    }

    fun printStatement() {
        statementPrinter.print(transactionRepository.allTransactions)
    }
}

