package bankingkata

data class StatementLine(private val transaction: Transaction, val runningBalance: Int){
    val amount: Int
        get() = transaction.amount
    val date: String
        get() = transaction.date


}
