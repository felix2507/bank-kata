package bankingkata

import java.text.DecimalFormat

class LinePrinter(private val console: Console) {
    companion object {
        const val HEADER = "DATE | AMOUNT | BALANCE"
    }

    fun print(statementLine: StatementLine) {
        console.printLine("${statementLine.date} | ${formatWithDecimal(statementLine.amount)} | ${formatWithDecimal(statementLine.runningBalance)}")
    }

    private fun formatWithDecimal(value: Int): String{
        return "$value.00"
    }

    fun printHeader() {
        console.printLine(HEADER)
    }

}
