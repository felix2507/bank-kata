package bankingkata

private const val HEADER = "DATE | AMOUNT | BALANCE"

class StatementPrinter(private val linePrinter: LinePrinter) {
    fun print(transactions: List<Transaction>) {
        linePrinter.printHeader()
        printTransactions(transactions)
    }

    private fun printTransactions(transactions: List<Transaction>) {
        var runningBalance = 0
        transactions
            .map {
                runningBalance += it.amount
                return@map StatementLine(it, runningBalance)
            }
            .reversed()
            .forEach(linePrinter::print)
    }

}
