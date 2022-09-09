package bankingkata

class TransactionRepository(val systemDateProvider: SystemDateProvider) {
    private val transactions = mutableListOf<Transaction>()
    val allTransactions: List<Transaction>
        get() {
            return transactions.toList()
        }

    fun addDeposit(amount: Int) {
        val deposit = Transaction(systemDateProvider.todayAsString(), amount)
        transactions.add(deposit)
    }

    fun addWithdraw(amount: Int) {
        val withdraw = Transaction(systemDateProvider.todayAsString(), -amount)
        transactions.add(withdraw)
    }



}
